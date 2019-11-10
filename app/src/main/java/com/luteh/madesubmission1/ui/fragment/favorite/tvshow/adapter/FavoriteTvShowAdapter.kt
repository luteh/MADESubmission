package com.luteh.madesubmission1.ui.fragment.favorite.tvshow.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.data.model.db.TvShowData

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteTvShowAdapter(
    private val favoriteTvShowItemListener: FavoriteTvShowItemListener
) : PagedListAdapter<TvShowData, FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowViewHolder =
        FavoriteTvShowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            ),
            favoriteTvShowItemListener
        )

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val data = getItem(position)
        holder.bindTo(data)
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowData>() {
            override fun areItemsTheSame(oldNote: TvShowData, newNote: TvShowData): Boolean {
                return oldNote.name.equals(newNote.name)
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: TvShowData, newNote: TvShowData): Boolean {
                return oldNote == newNote
            }
        }
    }
}