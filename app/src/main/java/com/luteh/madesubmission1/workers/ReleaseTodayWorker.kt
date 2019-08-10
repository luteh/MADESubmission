package com.luteh.madesubmission1.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * Created by Luthfan Maftuh on 8/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class ReleaseTodayWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        // TODO: 8/10/2019 Implement API service
        return Result.success()
    }
}