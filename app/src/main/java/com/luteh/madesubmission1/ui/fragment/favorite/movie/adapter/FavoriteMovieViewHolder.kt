package com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.MovieData
import kotlinx.android.synthetic.main.home_item.view.*

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieViewHolder(
    itemView: View,
    private val favoriteMovieItemListener: FavoriteMovieItemListener
) : RecyclerView.ViewHolder(itemView) {

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
                    favoriteMovieItemListener.onItemClicked(data)
                }
            }
        }
    }
}