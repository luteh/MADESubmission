package com.luteh.madesubmission1.workers

import android.content.Context
import android.util.Log
import androidx.work.*
import com.luteh.madesubmission1.common.constant.AppConstant
import java.util.concurrent.TimeUnit

/**
 * Created by Luthfan Maftuh on 8/6/2019.
 * Email luthfanmaftuh@gmail.com
 */
class NotifyInitialWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    private val TAG = "NotifyInitialWorker"
    private val periodicWorkTag = "periodicNotifiWork"

    private val dailyReminderWorkInputData =
        Data.Builder()
            .putString(AppConstant.EXTRA_NOTIF_TITLE, AppConstant.EXTRA_NOTIF_TITLE)
            .putString(AppConstant.EXTRA_NOTIF_TEXT, AppConstant.EXTRA_NOTIF_TEXT)
            .putInt(AppConstant.EXTRA_NOTIF_ID, (Math.random() * 50 + 1).toInt())
            .build()

    override fun doWork(): Result {
        startDailyReminderWorker()
        return Result.success()
    }

    private fun startDailyReminderWorker() {
        val requestBuilder =
            PeriodicWorkRequest.Builder(DailyReminderWorker::class.java, 15, TimeUnit.MINUTES)
                .setInputData(dailyReminderWorkInputData)

        WorkManager.getInstance().enqueueUniquePeriodicWork(
            periodicWorkTag,
            ExistingPeriodicWorkPolicy.REPLACE,
            requestBuilder.build()
        )
    }
}