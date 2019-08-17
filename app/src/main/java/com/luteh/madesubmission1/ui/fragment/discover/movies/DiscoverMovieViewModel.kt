package com.luteh.madesubmission1.ui.fragment.discover.movies

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.MovieData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Suppress("UnstableApiUsage")
class DiscoverMovieViewModel(private val myRepository: MyRepository) :
    BaseViewModel<DiscoverMovieNavigator>() {

    private val TAG = "DiscoverMovieViewModel"

    val movieDatas: MutableLiveData<List<MovieData>> = MutableLiveData()

    fun getMovieData(language: String) {
        compositeDisposable.add(
            myRepository.getMovieData(language)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { mIsLoading.value = true }
                .doOnTerminate { mIsLoading.value = false }
                .subscribe({ response ->
                    movieDatas.value = response.movieData
                },
                    { throwable ->
                        Log.e(TAG, "getMovieData: ${throwable.message}")
                        mNavigator?.onErrorGetMovieData()
                    })
        )
    }

    fun searchMovie(query: String) {
        compositeDisposable.add(
            myRepository.searchMovie(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { mIsLoading.value = true }
                .doOnTerminate { mIsLoading.value = false }
                .subscribe({ response ->
                    movieDatas.value = response.results
                }, { throwable ->
                    Log.e(TAG, "searchMovie: ${throwable.message}")
                    mNavigator?.onErrorGetMovieData()
                })
        )
    }
}