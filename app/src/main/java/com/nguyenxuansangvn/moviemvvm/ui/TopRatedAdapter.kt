package com.nguyenxuansangvn.moviemvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nguyenxuansangvn.moviemvvm.BR
import com.nguyenxuansangvn.moviemvvm.R
import com.nguyenxuansangvn.moviemvvm.data.model.Movie
import com.nguyenxuansangvn.moviemvvm.databinding.MovieItemBinding

class TopRatedDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

class TopRatedAdapter : ListAdapter<Movie, TopRatedAdapter.ViewHolder>(TopRatedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = DataBindingUtil.inflate<MovieItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.movie_item,
            parent,
            false
        )
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    class ViewHolder(
        private val databinding: MovieItemBinding
    ) :
        RecyclerView.ViewHolder(databinding.root) {
        fun bindData(movie: Movie) {
            databinding.apply {
                setVariable(BR.movie, movie)
                executePendingBindings()
            }
        }
    }
}
