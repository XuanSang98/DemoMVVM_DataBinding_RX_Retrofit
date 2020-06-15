package com.nguyenxuansangvn.moviemvvm.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import com.nguyenxuansangvn.moviemvvm.data.repository.TopRatedRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.schedulers.Schedulers

class TopRatedViewModel(
    private val topRatedRepository: TopRatedRepository,
    private val apiKey: String,
    private val language: String,
    private val page: Int
) : ViewModel() {

    val topRated = ObservableField<TopRated>()

    private val compositeDisposable = CompositeDisposable()

    fun getTopRated() {
        topRatedRepository.getTopRated(apiKey, language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                topRated.set(it)
            }
            .addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
