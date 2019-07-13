package com.luteh.madesubmission1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.ui.activity.detail.DetailViewModel
import com.luteh.madesubmission1.ui.fragment.discover.movies.DiscoverMovieViewModel
import com.luteh.madesubmission1.ui.fragment.discover.tvshow.DiscoverTvShowViewModel
import com.luteh.madesubmission1.ui.fragment.favorite.movie.FavoriteMovieViewModel
import com.luteh.madesubmission1.ui.fragment.favorite.tvshow.FavoriteTvShowViewModel

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MyViewModelFactory(private val myRepository: MyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DiscoverMovieViewModel::class.java) -> DiscoverMovieViewModel(myRepository) as T
            modelClass.isAssignableFrom(DiscoverTvShowViewModel::class.java) -> DiscoverTvShowViewModel(myRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(myRepository) as T
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> FavoriteMovieViewModel(myRepository) as T
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> FavoriteTvShowViewModel(myRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}