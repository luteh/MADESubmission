package com.luteh.madesubmission1.common.constant

import com.luteh.madesubmission1.BuildConfig

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */
object AppConstant {

    const val BASE_URL = "https://api.themoviedb.org/"
    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w185/"
    const val API_KEY = BuildConfig.TMDB_API_KEY

    const val KEY_BUNDLE_HOME_DATA = "KEY_BUNDLE_HOME_DATA"

    const val LANGUAGE_CODE_ENGLISH = "en-US"
    const val LANGUAGE_CODE_INDONESIAN = "id-ID"

    const val DATABASE_NAME = "mydatabase.db"
    const val DATABASE_TABLE_MOVIE = "movie_db"
    const val DATABASE_TABLE_TV_SHOW = "tv_show_db"

    const val KEY_EXTRA_NOTIF_DAILY_TITLE = "KEY_EXTRA_NOTIF_DAILY_TITLE"
    const val KEY_EXTRA_NOTIF_DAILY_TEXT = "KEY_EXTRA_NOTIF_DAILY_TEXT"
    const val KEY_EXTRA_NOTIF_DAILY_ID = "KEY_EXTRA_NOTIF_DAILY_ID"

    const val DAILY_REMINDER_WORK_NAME = "daily_reminder_worker"
    const val RELEASE_REMINDER_WORK_NAME = "release_reminder_worker"

    const val MOVIE_SCREEN = "MOVIE SCREEN"
    const val TV_SHOW_SCREEN = "TV SHOW SCREEN"
}