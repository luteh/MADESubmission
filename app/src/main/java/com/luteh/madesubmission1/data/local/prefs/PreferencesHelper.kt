package com.luteh.madesubmission1.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.luteh.madesubmission1.R

/**
 * Created by Luthfan Maftuh on 7/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
object PreferencesHelper {

    private lateinit var mPrefs: SharedPreferences
    private const val PREF_NAME = "mypref"

    private var RELEASE_REMINDER = ""
    private var DAILY_REMINDER = ""

    fun isReleaseReminderEnabled(): Boolean =
        mPrefs.getBoolean(RELEASE_REMINDER, true)

    fun isDailyReminderEnabled(): Boolean =
        mPrefs.getBoolean(DAILY_REMINDER, true)

    operator fun invoke(context: Context): PreferencesHelper {
        RELEASE_REMINDER = context.getString(R.string.key_release_reminder)
        DAILY_REMINDER = context.getString(R.string.key_daily_reminder)

        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return this@PreferencesHelper
    }
}