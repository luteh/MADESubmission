package com.luteh.madesubmission1.ui.fragment.discover.tvshow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.TvShowData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Suppress("UnstableApiUsage")
class DiscoverTvShowViewModel(private val myRepository: MyRepository) : BaseViewModel<DiscoverTvShowNavigator>() {

    private val TAG = "DiscoverTvShowViewModel"

    val tvShowDatas: MutableLiveData<List<TvShowData>> = MutableLiveData()

    fun getTvShowData(language: String) {
        compositeDisposable.add(
            myRepository.getTvShowData(language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { mIsLoading.value = true }
                .doOnTerminate { mIsLoading.value = false }
                .subscribe({ response ->
                    tvShowDatas.value = response.tvShowData
                },
                    { throwable -> Log.e(TAG, "getTvShowData: ${throwable.message}")
                    mNavigator?.onErrorGetTvShowData()})
        )
    }
}