package com.luteh.madesubmission1.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.data.model.HomeData
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.movie.MovieData
import kotlinx.android.synthetic.main.home_item.view.*

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */

private lateinit var onHomeItemClickListener: OnHomeItemClickListener

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var dataSources: List<MovieData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSource(data: List<MovieData>) {
        dataSources = data
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: OnHomeItemClickListener) {
        onHomeItemClickListener = listener
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(data: MovieData) {

        data.let {
            with(itemView) {
                //                iv_main_item.setImageResource(it.imageResId)
                tv_main_title_item.text = it.title
                tv_main_release_date_item.text = it.releaseDate
                tv_main_overview_item.text = it.overview

                Glide.with(itemView)
                    .load(AppConstant.BASE_URL_IMAGE + it.posterPath)
                    .dontAnimate()
                    .into(iv_main_item)

                setOnClickListener {
                    onHomeItemClickListener.onItemClicked(data)
                }
            }
        }
    }
}
