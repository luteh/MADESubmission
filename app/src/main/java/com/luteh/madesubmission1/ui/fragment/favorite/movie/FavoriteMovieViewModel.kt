package com.luteh.madesubmission1.ui.fragment.favorite.movie

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.MovieData

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieViewModel(private val myRepository: MyRepository) :
    BaseViewModel<FavoriteMovieNavigator>() {

    fun loadAllMovies(): LiveData<PagedList<MovieData>> =
        myRepository.loadAllMovies()
}