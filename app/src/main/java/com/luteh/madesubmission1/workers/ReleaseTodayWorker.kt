package com.luteh.madesubmission1.workers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.luteh.madesubmission1.data.MyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Luthfan Maftuh on 8/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class ReleaseTodayWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams), KodeinAware {

    private val TAG = "ReleaseTodayWorker"

    override val kodein: Kodein by closestKodein(context)
    private val myRepository: MyRepository by instance()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun doWork(): Result {

        getMovieReleaseData()

        WorkerUtils.startReleaseTodayReminderWorker(applicationContext)

        return Result.success()
    }

    private fun getMovieReleaseData() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val todayDate = dateFormat.format(Calendar.getInstance().time)

        compositeDisposable.add(
            myRepository.getMovieReleaseData(todayDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(TAG, "doWork: ${it.totalPages}")

                    for (i in 0 until 3) {
                        val data = it.results[i]
                        WorkerUtils.sendNotification(
                            applicationContext,
                            data.title,
                            "${data.title} has been release today!",
                            Random().nextInt(100)
                        )
                    }

                    disposeComposite()
                }, {
                    Log.e(TAG, "doWork: ${it.message}")
                    disposeComposite()
                })
        )
    }

    private fun disposeComposite() {
        compositeDisposable.dispose()
    }
}