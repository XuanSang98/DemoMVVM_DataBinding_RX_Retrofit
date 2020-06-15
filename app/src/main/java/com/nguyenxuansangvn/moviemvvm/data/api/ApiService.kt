package com.nguyenxuansangvn.moviemvvm.data.api

import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/top_rated?")
    fun getTopRated(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Observable<TopRated>
}
