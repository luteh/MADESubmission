package com.luteh.madesubmission1.workers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.ui.activity.home.HomeActivity
import java.util.*

/**
 * Created by Luthfan Maftuh on 8/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
object WorkerUtils {

    fun sendNotification(context: Context, title: String, message: String, id: Int) {
        val intent = Intent(context, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(AppConstant.EXTRA_NOTIF_ID, id)

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