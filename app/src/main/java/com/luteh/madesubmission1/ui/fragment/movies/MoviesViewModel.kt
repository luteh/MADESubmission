package com.luteh.madesubmission1.ui.fragment.movies

import android.content.Context
import androidx.lifecycle.ViewModel
import com.luteh.madesubmission1.data.HomeDataFactory
import com.luteh.madesubmission1.model.HomeData

/**
 * Created by Luthfan Maftuh on 9/23/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MoviesViewModel : ViewModel() {

    fun getMovieDatas(context: Context?): List<HomeData> {
        return HomeDataFactory.getMovieDatas(context!!)
    }
}