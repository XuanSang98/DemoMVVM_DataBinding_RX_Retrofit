package com.nguyenxuansangvn.moviemvvm.ui

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nguyenxuansangvn.moviemvvm.data.model.TopRated
import kotlin.jvm.JvmStatic

object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(image: ImageView,urlImage: String){
        Glide.with(image.context)
            .load("https://image.tmdb.org/t/p/w500"+urlImage)
            .into(image)
    }

    @JvmStatic
    @BindingAdapter("data")
    fun setData(recyclerView: RecyclerView, movies: TopRated?){
        Log.d("Binding Adapter", movies.toString())
        movies?.let {(recyclerView.adapter as TopRatedAdapter).submitList(movies.results)  }
    }

}
