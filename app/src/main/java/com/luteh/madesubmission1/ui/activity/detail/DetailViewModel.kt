package com.luteh.madesubmission1.ui.activity.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Luthfan Maftuh on 7/9/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DetailViewModel(private val myRepository: MyRepository) : BaseViewModel<DetailNavigator>() {

    private val TAG = "DetailViewModel"

    val isDataSaved: MutableLiveData<Boolean> = MutableLiveData()

    fun saveDetailData(data: Any) {
        if (data is MovieData)
            saveMovie(data)
        else if (data is TvShowData)
            saveTvShow(data)
    }

    private fun saveMovie(data: MovieData) {
        compositeDisposable.add(
            myRepository.saveMovie(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "saveMovie: Success")
                    isDataSaved.value = true
                    mNavigator?.onSuccessSaveDetailData()
                }, {
                    Log.e(TAG, "saveMovie: ${it.message}")
                    mNavigator?.onErrorSaveDetailData()
                })
        )
    }

    private fun saveTvShow(data: TvShowData) {
        compositeDisposable.add(
            myRepository.saveTvShow(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "saveTvShow: Success")
                    isDataSaved.value = true
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
                .subscribe({
                    Log.d(TAG, "getMovieById: $it")
                    isDataSaved.value = true
                }, {
                    isDataSaved.value = false
                    Log.e(TAG, "getMovieById: ${it.message}")
                })
        )
    }

    private fun getTvShowById(id: Int) {
        compositeDisposable.add(
            myRepository.getTvShowById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isDataSaved.value = true
                }, {
                    isDataSaved.value = false
                    Log.e(TAG, "getTvShowById: ${it.message}")
                })
        )
    }

    fun deleteDetailData(data: Any) {
        if (data is MovieData)
            deleteMovieById(data.id)
        else if (data is TvShowData)
            deleteTvShowById(data.id)
    }

    private fun deleteMovieById(id: Int) {
        compositeDisposable.add(
            myRepository.deleteMovieById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isDataSaved.value = false
                }, {
                    Log.e(TAG, "deleteMovieById: ${it.message}")
                })
        )
    }

    private fun deleteTvShowById(id: Int) {

        compositeDisposable.add(
            myRepository.deleteTvShowById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    isDataSaved.value = false
                }, {
                    Log.e(TAG, "deleteTvShowById: ${it.message}")
                })
        )
    }
}