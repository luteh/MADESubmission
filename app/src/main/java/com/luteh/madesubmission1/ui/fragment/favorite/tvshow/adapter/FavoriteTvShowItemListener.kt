package com.luteh.madesubmission1.ui.fragment.favorite.tvshow.adapter

import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface FavoriteTvShowItemListener {
    fun onItemClicked(data: TvShowData)
}