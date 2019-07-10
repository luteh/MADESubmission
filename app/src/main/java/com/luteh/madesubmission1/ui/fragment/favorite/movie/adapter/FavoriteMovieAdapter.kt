package com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.data.model.db.MovieDb

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieAdapter(
    private val favoriteMovieItemListener: FavoriteMovieItemListener
) : RecyclerView.Adapter<FavoriteMovieViewHolder>() {

    private var dataSources: List<MovieDb> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder =
        FavoriteMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            ),
            favoriteMovieItemListener
        )

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSource(data: List<MovieDb>) {
        dataSources = data
        notifyDataSetChanged()
    }
}