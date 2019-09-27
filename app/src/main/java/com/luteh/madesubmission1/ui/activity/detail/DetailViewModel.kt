package com.luteh.madesubmission1.ui.activity.detail

import androidx.lifecycle.ViewModel
import com.luteh.madesubmission1.model.HomeData

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DetailViewModel : ViewModel() {

    var homeData: HomeData? = null
        get() = field
        set(value) {
            field = value
        }
}