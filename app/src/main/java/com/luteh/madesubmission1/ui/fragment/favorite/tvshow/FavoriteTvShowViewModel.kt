package com.luteh.madesubmission1.ui.fragment.favorite.tvshow

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteTvShowViewModel(private val myRepository: MyRepository) :
    BaseViewModel<FavoriteTvShowNavigator>() {

    private val TAG = "FavoriteTvShowViewModel"

    val tvShowDataList: MutableLiveData<List<TvShowData>> = MutableLiveData()

    fun loadAllTvShows() {
        compositeDisposable.add(
            myRepository.loadAllTvShows()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    tvShowDataList.value = it
                }, {
                    Log.e(TAG, "loadAllTvShows: ${it.message}")
                })
        )
    }
}