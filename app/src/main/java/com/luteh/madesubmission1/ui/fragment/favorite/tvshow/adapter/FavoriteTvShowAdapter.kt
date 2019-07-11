package com.luteh.madesubmission1.ui.fragment.favorite.tvshow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.data.model.db.TvShowData

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteTvShowAdapter(
    private val favoriteTvShowItemListener: FavoriteTvShowItemListener
) : RecyclerView.Adapter<FavoriteTvShowViewHolder>() {

    private var dataSources: List<TvShowData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder =
        FavoriteTvShowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            ),
            favoriteTvShowItemListener
        )

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSource(data: List<TvShowData>) {
        dataSources = data
        notifyDataSetChanged()
    }
}