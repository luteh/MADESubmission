package com.luteh.madesubmission1.ui.fragment.tvshow

import android.content.Context
import androidx.lifecycle.ViewModel
import com.luteh.madesubmission1.data.HomeDataFactory
import com.luteh.madesubmission1.model.HomeData

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowViewModel:ViewModel() {

    fun getTvShowDatas(context: Context?): List<HomeData> {
        return HomeDataFactory.getTvShowDatas(context!!)
    }
}