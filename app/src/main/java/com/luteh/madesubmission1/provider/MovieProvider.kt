package com.luteh.madesubmission1.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.local.db.MyDatabase
import com.luteh.madesubmission1.data.local.db.MyDbHelper


class MovieProvider : ContentProvider() {

    companion object {

        /** The authority of this content provider.  */
        val AUTHORITY = "com.luteh.madesubmission1"

        val TABLE = "moviedatabase"

        /** The URI for the Menu table.  */
        val URI_MOVIE = Uri.parse(
            "content://$AUTHORITY/${AppConstant.DATABASE_TABLE_MOVIE}"
        )

        private val MOVIE = 1
        private val MOVIE_ID = 2

        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    }

    init {
        // content://com.luteh.madesubmission1/movie_db
        sUriMatcher.addURI(AUTHORITY, AppConstant.DATABASE_TABLE_MOVIE, MOVIE)

        // content://com.luteh.madesubmission1/movie_db/id
        sUriMatcher.addURI(
            AUTHORITY,
            "${AppConstant.DATABASE_TABLE_MOVIE}/#",
            MOVIE_ID
        )
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        val db = MyDatabase.invoke(context!!).openHelper.readableDatabase
        val cursor: Cursor?
        cursor = when (sUriMatcher.match(uri)) {
            MOVIE -> {
                db.query("SELECT * FROM ${AppConstant.DATABASE_TABLE_MOVIE}")
            }
            else -> null
        }
        return cursor
    }


    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}
