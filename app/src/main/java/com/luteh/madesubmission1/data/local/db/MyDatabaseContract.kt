package com.luteh.madesubmission1.data.local.db

import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns
import android.service.notification.Condition.SCHEME
import androidx.room.util.CursorUtil.getColumnIndex




/**
 * Created by Luthfan Maftuh on 8/18/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MyDatabaseContract {

    companion object {
        val AUTHORITY = "com.luteh.madesubmission1"
        private val SCHEME = "content"

        fun getColumnString(cursor: Cursor, columnName: String): String {
            return cursor.getString(cursor.getColumnIndex(columnName))
        }

        fun getColumnInt(cursor: Cursor, columnName: String): Int {
            return cursor.getInt(cursor.getColumnIndex(columnName))
        }

        fun getColumnLong(cursor: Cursor, columnName: String): Long {
            return cursor.getLong(cursor.getColumnIndex(columnName))
        }

    }

    class MovieColumn : BaseColumns {
        companion object {
            /* Table name used by our database*/
            val TABLE_NAME = "movie"

            // Note title
            val TITLE = "title"
            // Note description
            val DESCRIPTION = "description"
            // Note date
            val DATE = "date"

            // Base content yang digunakan untuk akses content provider
            val CONTENT_URI = Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build()
        }
    }
}