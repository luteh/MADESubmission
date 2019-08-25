package com.luteh.madesubmission1.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.luteh.madesubmission1.common.constant.AppConstant

/**
 * Created by Luthfan Maftuh on 8/6/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DailyReminderWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        val title = inputData.getString(AppConstant.KEY_EXTRA_NOTIF_DAILY_TITLE)
        val text = inputData.getString(AppConstant.KEY_EXTRA_NOTIF_DAILY_TEXT)
        val id = inputData.getLong(AppConstant.KEY_EXTRA_NOTIF_DAILY_ID, 0).toInt()

        WorkerUtils.sendNotification(applicationContext, title!!, text!!, id)

        WorkerUtils.startDailyReminderWorker(applicationContext)
        return Result.success()
    }
}