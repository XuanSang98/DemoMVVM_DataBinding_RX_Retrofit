package com.nguyenxuansangvn.moviemvvm.data.repository

import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import com.nguyenxuansangvn.moviemvvm.data.api.ApiService
import com.nguyenxuansangvn.moviemvvm.data.source.remote.TopRatedRemoteDataSource
import io.reactivex.rxjava3.core.Observable

class TopRatedRepository(
    var topRatedRemoteDataSource: TopRatedRemoteDataSource,
    val apiServie: ApiService
) {
    fun getTopRated(apiKey: String, language: String, page: Int): Observable<TopRated> {
        topRatedRemoteDataSource = TopRatedRemoteDataSource(apiServie)
        return topRatedRemoteDataSource.getTopRated(apiKey, language, page)
    }
}
