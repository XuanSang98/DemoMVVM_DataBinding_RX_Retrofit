package com.nguyenxuansangvn.moviemvvm.data.source

import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import io.reactivex.rxjava3.core.Observable

class TopRatedDataSource {
    interface Remote {
        fun getTopRated(
            apiKey: String,
            language: String,
            page: Int
        ): Observable<TopRated>
    }
    interface Local
}
