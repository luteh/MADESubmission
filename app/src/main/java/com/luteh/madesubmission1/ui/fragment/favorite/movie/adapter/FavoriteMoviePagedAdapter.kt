package com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.data.model.db.MovieData

/**
 * Created by Luthfan Maftuh on 11/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMoviePagedAdapter(
    private val favoriteMovieItemListener: FavoriteMovieItemListener
) :
    PagedListAdapter<MovieData, FavoriteMovieViewHolder>(
        DIFF_CALLBACK
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder =
        FavoriteMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            ),
            favoriteMovieItemListener
        )

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val data = getItem(position)
        holder.bindTo(data)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieData>() {
            override fun areItemsTheSame(oldNote: MovieData, newNote: MovieData): Boolean {
                return oldNote.title.equals(newNote.title)
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: MovieData, newNote: MovieData): Boolean {
                return oldNote == newNote
            }
        }
    }
}