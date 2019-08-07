package com.luteh.madesubmission1.workers

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.luteh.madesubmission1.common.constant.AppConstant
import java.util.*

/**
 * Created by Luthfan Maftuh on 8/4/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DailyReminderWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    private val TAG = "DailyReminderWorker"

    override fun doWork(): Result {
        Log.d(TAG, "doWork: daily worker")
        val title = inputData.getString(AppConstant.EXTRA_NOTIF_TITLE)
        val text = inputData.getString(AppConstant.EXTRA_NOTIF_TEXT)
        val id = inputData.getLong(AppConstant.EXTRA_NOTIF_ID, 0).toInt()

        WorkerUtils.sendNotification(applicationContext, title!!, text!!, id)
        return Result.success()
    }

    /*companion object {
        private const val REMINDER_WORK_NAME = "reminder"
        private const val PARAM_NAME = "name" // optional - send parameter to worker
        // private const val RESULT_ID = "id"

        // Set the alarm to start at approximately 2:00 p.m.
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 14)
        }

        fun run() {

        }

        *//*fun runAt() {
            val workManager = WorkManager.getInstance()

            // trigger at 8:30am
            val alarmTime = LocalTime.of(8, 30)
            var now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)
            val nowTime = now.toLocalTime()
            // if same time, schedule for next day as well
            // if today's time had passed, schedule for next day
            if (nowTime == alarmTime || nowTime.isAfter(alarmTime)) {
                now = now.plusDays(1)
            }
            now = now.withHour(alarmTime.hour).withMinute(alarmTime.minute) // .withSecond(alarmTime.second).withNano(alarmTime.nano)
            val duration = Duration.between(LocalDateTime.now(), now)

            Timber.d("runAt=${duration.seconds}s")

            // optional constraints
            *//**//*
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()
             *//**//*

            // optional data
            val data = workDataOf(PARAM_NAME to "Timer 01")

            val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
                .setInitialDelay(duration.seconds, TimeUnit.SECONDS)
                // .setConstraints(constraints)
                .setInputData(data) // optional
                .build()

            workManager.enqueueUniqueWork(REMINDER_WORK_NAME, ExistingWorkPolicy.REPLACE, workRequest)
        }*//*

        fun cancel() {
            val workManager = WorkManager.getInstance()
            workManager.cancelUniqueWork(REMINDER_WORK_NAME)
        }
    }*/
}