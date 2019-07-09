package com.luteh.madesubmission1.ui.activity.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.api.movie.MovieData
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData
import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 7/9/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DetailViewModel(private val myRepository: MyRepository) : BaseViewModel<DetailNavigator>() {

    private val TAG = "DetailViewModel"

    val isDataNotNull: MutableLiveData<Boolean> = MutableLiveData()

    fun saveDetailData(data: Any) {
        if (data is MovieData)
            saveMovie(data)
        else if (data is TvShowData)
            saveTvShow(data)
    }

    private fun saveMovie(data: MovieData) {
        val movieDb = MovieDb(
            data.id,
            data.voteAverage,
            data.title,
            data.popularity,
            data.posterPath,
            data.originalLanguage,
            data.backdropPath, data.overview, data.releaseDate
        )
        compositeDisposable.add(
            myRepository.saveMovie(movieDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    Log.d(TAG, "saveMovie: Success")
                    mNavigator?.onSuccessSaveDetailData()
                }, {
                    Log.e(TAG, "saveMovie: ${it.message}")
                    mNavigator?.onErrorSaveDetailData()
                })

        )
    }

    private fun saveTvShow(data: TvShowData) {
        val tvShowDb = TvShowDb(
            data.name,
            data.popularity,
            data.firstAirDate,
            data.backdropPath,
            data.originalLanguage,
            data.id,
            data.voteAverage, data.overview, data.posterPath
        )
        compositeDisposable.add(
            myRepository.saveTvShow(tvShowDb)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    Log.d(TAG, "saveTvShow: Success")
                    mNavigator?.onSuccessSaveDetailData()
                }, {
                    Log.e(TAG, "saveTvShow: ${it.message}")
                    mNavigator?.onErrorSaveDetailData()
                })

        )
    }

    fun getDetailData(data: Any) {
        if (data is MovieData)
            getMovieById(data.id)
        else if (data is TvShowData)
            getTvShowById(data.id)
    }

    private fun getMovieById(id: Int) {
        compositeDisposable.add(
            myRepository.getMovieById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    Log.d(TAG, "getMovieById: $it")
                    isDataNotNull.value = true
                }, {
                    isDataNotNull.value = false
                    Log.e(TAG, "getMovieById: ${it.message}")
                })
        )
    }

    private fun getTvShowById(id: Int) {
        compositeDisposable.add(
            myRepository.getTvShowById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mIsLoading.value = true }
                .doOnSubscribe { mIsLoading.value = false }
                .subscribe({
                    isDataNotNull.value = true
                }, {
                    isDataNotNull.value = false
                    Log.e(TAG, "getTvShowById: ${it.message}")
                })
        )
    }
}