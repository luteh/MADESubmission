package com.luteh.madesubmission1.ui.activity.settings

import androidx.lifecycle.LifecycleOwner
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.workers.NotifyInitialWorker

/**
 * Created by Luthfan Maftuh on 8/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
class SettingsViewModel(private val myRepository: MyRepository) :
    BaseViewModel<SettingsNavigator>() {

    private val TAG = "SettingsViewModel"

    private val dailyReminderWorkName = "dailyReminderWorker"
    private val periodicWorkTag = "periodicNotifiWork"

    private val workManager = WorkManager.getInstance()

    fun startDailyReminder(owner: LifecycleOwner) {
        val requestBuilder = OneTimeWorkRequest.Builder(NotifyInitialWorker::class.java)
//            .setInitialDelay(5, TimeUnit.SECONDS)
            .build()

        workManager.beginUniqueWork(
            dailyReminderWorkName,
            ExistingWorkPolicy.REPLACE,
            requestBuilder
        ).enqueue()
    }

    fun cancelDailyReminder() {
        workManager.cancelUniqueWork(dailyReminderWorkName)
        workManager.cancelUniqueWork(periodicWorkTag)
    }

}