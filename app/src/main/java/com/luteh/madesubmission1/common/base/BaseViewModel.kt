package com.luteh.madesubmission1.common.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
abstract class BaseViewModel<N> : ViewModel() {

    var mIsLoading = MutableLiveData<Boolean>()

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    var mNavigator: N? = null
        get() = WeakReference(field).get()
        set(navigator) {
            field = navigator
        }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}