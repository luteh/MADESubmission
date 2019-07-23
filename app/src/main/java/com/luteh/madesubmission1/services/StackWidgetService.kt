package com.luteh.madesubmission1.services

import android.content.Intent
import android.widget.RemoteViewsService

/**
 * Created by Luthfan Maftuh on 7/19/2019.
 * Email luthfanmaftuh@gmail.com
 */
class StackWidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory =
        StackRemoteViewsFactory(this.applicationContext)
}