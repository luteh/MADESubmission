package com.luteh.favoritemovieapp.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.luteh.favoritemovieapp.common.AppConstant
import com.luteh.favoritemovieapp.data.MovieData
import com.luteh.qasirtest.internal.GlideApp
import kotlinx.android.synthetic.main.main_item.view.*

/**
 * Created by Luthfan Maftuh on 8/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindTo(movieData: MovieData) {
        movieData.let {
            with(itemView) {
                tv_main_title_item.text = it.title
                rating_main_item.rating = (it.voteAverage / 2).toFloat()

                GlideApp.with(this)
                    .load("${AppConstant.BASE_URL_IMAGE}${it.backdropPath}")
                    .roundedCorners(context, 4)
                    .dontAnimate()
                    .into(iv_main_item)
            }
        }
    }
}