package com.luteh.madesubmission1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.ui.activity.detail.DetailViewModel
import com.luteh.madesubmission1.ui.fragment.favorite.movie.FavoriteMovieViewModel
import com.luteh.madesubmission1.ui.fragment.movies.MovieViewModel
import com.luteh.madesubmission1.ui.fragment.tvshow.TvShowViewModel

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MyViewModelFactory(private val myRepository: MyRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(myRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(myRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(myRepository) as T
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> FavoriteMovieViewModel(myRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}