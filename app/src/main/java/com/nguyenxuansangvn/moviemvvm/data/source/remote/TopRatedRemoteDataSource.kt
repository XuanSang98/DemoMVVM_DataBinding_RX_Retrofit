package com.nguyenxuansangvn.moviemvvm.data.source.remote

import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import com.nguyenxuansangvn.moviemvvm.data.api.ApiService
import com.nguyenxuansangvn.moviemvvm.data.source.TopRatedDataSource
import io.reactivex.rxjava3.core.Observable

class TopRatedRemoteDataSource(private val apiService: ApiService) : TopRatedDataSource.Remote {
    override fun getTopRated(apiKey: String, language: String, page: Int): Observable<TopRated> {
        return apiService.getTopRated(apiKey, language, page)
    }
}
