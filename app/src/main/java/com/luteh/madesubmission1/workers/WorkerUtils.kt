package com.luteh.madesubmission1.workers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.ui.activity.home.HomeActivity
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Luthfan Maftuh on 8/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
object WorkerUtils {

    private fun getConstraints(networkType: NetworkType): Constraints = Constraints.Builder()
        .setRequiresCharging(false)
        .setRequiresStorageNotLow(false)
        .setRequiredNetworkType(networkType)
        .setRequiresBatteryNotLow(false)
        .build()

    private fun getDailyWorkData(context: Context) =
        workDataOf(
            AppConstant.KEY_EXTRA_NOTIF_DAILY_TITLE to context.getString(R.string.title_catalogue_movie),
            AppConstant.KEY_EXTRA_NOTIF_DAILY_TEXT to context.getString(R.string.label_message_catalogue_movie),
            AppConstant.KEY_EXTRA_NOTIF_DAILY_ID to (Math.random() * 50 + 1).toInt()
        )

    private fun getDelayInMillis(hourOfDay: Int): Long {
        val currentDate = Calendar.getInstance()
        val dueDate = Calendar.getInstance()

        // Set Execution around [hourOfDay]:00:00 AM
        dueDate.timeInMillis = System.currentTimeMillis()
        dueDate.set(Calendar.HOUR_OF_DAY, hourOfDay)
        dueDate.set(Calendar.MINUTE, 0)
        dueDate.set(Calendar.SECOND, 0)

        // Add the times if current time greater than due time
        // To handle daily worker time if previous worker has been successful
        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24)
        }

        val timeDiff = dueDate.timeInMillis - currentDate.timeInMillis

        return timeDiff
    }

    fun startDailyReminderWorker(context: Context) {
        val requestBuilder = OneTimeWorkRequestBuilder<DailyReminderWorker>()
            .setInputData(getDailyWorkData(context))
            .setConstraints(getConstraints(NetworkType.NOT_REQUIRED))
            .setInitialDelay(getDelayInMillis(7), TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(context).beginUniqueWork(
            AppConstant.DAILY_REMINDER_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            requestBuilder
        ).enqueue()
    }

    fun startReleaseTodayReminderWorker(context: Context) {
        val requestBuilder = OneTimeWorkRequestBuilder<ReleaseTodayWorker>()
            .setConstraints(getConstraints(NetworkType.CONNECTED))
            .setInitialDelay(getDelayInMillis(8), TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(context).beginUniqueWork(
            AppConstant.RELEASE_REMINDER_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            requestBuilder
        ).enqueue()
    }

    fun sendNotification(context: Context, title: String, message: String, id: Int) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(AppConstant.KEY_EXTRA_NOTIF_DAILY_ID, id)

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, "default")
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)

        Objects.requireNonNull(notificationManager).notify(id, notification.build())
    }
}