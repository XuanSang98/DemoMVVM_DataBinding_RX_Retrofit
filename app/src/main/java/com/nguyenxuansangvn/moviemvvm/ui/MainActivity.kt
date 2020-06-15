package com.nguyenxuansangvn.moviemvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.nguyenxuansangvn.moviemvvm.R
import com.nguyenxuansangvn.moviemvvm.data.api.ApiService
import com.nguyenxuansangvn.moviemvvm.data.api.ServiceBuilder
import com.nguyenxuansangvn.moviemvvm.data.repository.TopRatedRepository
import com.nguyenxuansangvn.moviemvvm.data.source.remote.TopRatedRemoteDataSource
import com.nguyenxuansangvn.moviemvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val page = 2
    private val topRatedAdapter: TopRatedAdapter = TopRatedAdapter()
    private val viewModel by lazy {
        val apiService = ServiceBuilder.buildService(
            ApiService::class.java
        )
        val topRatedRemoteDataSource = TopRatedRemoteDataSource(apiService)
        val topRatedRepository = TopRatedRepository(topRatedRemoteDataSource, apiService)
        TopRatedViewModel(topRatedRepository, ServiceBuilder.API_KEY, ServiceBuilder.LANGUAGE, page)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recyclerViewTopRated.adapter = topRatedAdapter
        binding.viewModel = viewModel
        viewModel.getTopRated()
    }
}
