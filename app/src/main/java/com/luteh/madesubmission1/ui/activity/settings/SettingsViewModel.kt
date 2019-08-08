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
class SettingsViewModel(private val context: Context, private val myRepository: MyRepository) :
    BaseViewModel<SettingsNavigator>() {

    fun startDailyReminder() {
        WorkerUtils.startDailyReminderWorker(context)
    }

    fun cancelDailyReminder() {
        WorkManager.getInstance(context).cancelUniqueWork(AppConstant.DAILY_REMINDER_WORK_NAME)
    }

}