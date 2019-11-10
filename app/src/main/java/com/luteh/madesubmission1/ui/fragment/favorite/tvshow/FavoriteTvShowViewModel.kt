package com.luteh.madesubmission1.ui.fragment.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.TvShowData

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteTvShowViewModel(private val myRepository: MyRepository) :
    BaseViewModel<FavoriteTvShowNavigator>() {

    fun loadAllTvShows(): LiveData<PagedList<TvShowData>> = myRepository.loadAllTvShows()
}