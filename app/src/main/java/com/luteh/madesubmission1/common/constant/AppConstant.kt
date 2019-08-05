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

    const val EXTRA_NOTIF_TITLE = "Catalogue Movie"
    const val EXTRA_NOTIF_TEXT = "Catalogue Movie missing you!"
    const val EXTRA_NOTIF_ID = "daily_reminder_id"

    const val DAILY_REMINDER_WORK_NAME = "daily_reminder"
    const val RELEASE_REMINDER_WORK_NAME = "release_reminder"
}