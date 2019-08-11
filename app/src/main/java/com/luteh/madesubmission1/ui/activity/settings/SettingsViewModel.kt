package com.luteh.madesubmission1.ui.activity.settings

import android.content.Context
import androidx.work.WorkManager
import com.luteh.madesubmission1.common.base.BaseViewModel
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.workers.WorkerUtils

/**
 * Created by Luthfan Maftuh on 8/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
class SettingsViewModel(private val myRepository: MyRepository) :
    BaseViewModel<SettingsNavigator>() {

    fun startDailyReminder(context: Context) {
        WorkerUtils.startDailyReminderWorker(context)
    }

    fun cancelDailyReminder(context: Context) {
        WorkManager.getInstance(context).cancelUniqueWork(AppConstant.DAILY_REMINDER_WORK_NAME)
    }

    fun startReleaseTodayReminder(context: Context) {
        WorkerUtils.startReleaseTodayReminderWorker(context)
    }

    fun cancelReleaseTodayReminder(context: Context){
        WorkManager.getInstance(context).cancelUniqueWork(AppConstant.RELEASE_REMINDER_WORK_NAME)
    }
}