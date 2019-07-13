package com.luteh.madesubmission1.ui.fragment.discover.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.MovieData
import kotlinx.android.synthetic.main.home_item.view.*

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */

private lateinit var onMovieItemClickListener: OnMovieItemClickListener

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var dataSources: List<MovieData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSource(data: List<MovieData>) {
        dataSources = data
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: OnMovieItemClickListener) {
        onMovieItemClickListener = listener
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(data: MovieData) {

        data.let {
            with(itemView) {
                tv_main_title_item.text = it.title
                tv_main_release_date_item.text = it.releaseDate

                tv_main_overview_item.text = if (!it.overview.isNullOrEmpty()) {
                    it.overview
                } else {
                    context.getString(R.string.label_message_no_overview)
                }

                Glide.with(itemView)
                    .load(AppConstant.BASE_URL_IMAGE + it.posterPath)
                    .dontAnimate()
                    .into(iv_main_item)

                setOnClickListener {
                    onMovieItemClickListener.onItemClicked(data)
                }
            }
        }
    }
}
