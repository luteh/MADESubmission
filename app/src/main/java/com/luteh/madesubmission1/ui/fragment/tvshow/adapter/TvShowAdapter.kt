package com.luteh.madesubmission1.ui.fragment.tvshow.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData
import kotlinx.android.synthetic.main.home_item.view.*

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */

private lateinit var onTvShowItemClickListener: OnTvShowItemClickListener

class TvShowAdapter : RecyclerView.Adapter<TvShowViewHolder>() {

    private var dataSources: List<TvShowData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder =
        TvShowViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_item,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataSources.size

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val data = dataSources[position]
        holder.bindTo(data)
    }

    fun setDataSource(data: List<TvShowData>) {
        dataSources = data
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener: OnTvShowItemClickListener) {
        onTvShowItemClickListener = listener
    }
}

class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(data: TvShowData) {

        data.let {
            with(itemView) {
                tv_main_title_item.text = it.originalName
                tv_main_release_date_item.text = it.firstAirDate

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
                    onTvShowItemClickListener.onItemClicked(data)
                }
            }
        }
    }
}
