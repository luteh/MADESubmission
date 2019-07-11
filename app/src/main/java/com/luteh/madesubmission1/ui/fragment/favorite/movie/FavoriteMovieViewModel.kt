package com.luteh.madesubmission1.ui.fragment.favorite.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.MovieData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieViewModel(private val myRepository: MyRepository) :
    BaseViewModel<FavoriteMovieNavigator>() {

    private val TAG = "FavoriteMovieViewModel"

    val movieDataList: MutableLiveData<List<MovieData>> = MutableLiveData()

    fun loadAllMovies() {
        compositeDisposable.add(
            myRepository.loadAllMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    movieDataList.value = it
                }, {
                    Log.e(TAG, "loadAllMovies: ${it.message}")
                })
        )
    }
}