package com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter

import com.luteh.madesubmission1.data.model.db.MovieDb

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface FavoriteMovieItemListener {
    fun onItemClicked(data: MovieDb)
}