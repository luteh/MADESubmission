package com.luteh.madesubmission1.provider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import com.luteh.madesubmission1.common.constant.AppConstant.DATABASE_TABLE_MOVIE
import com.luteh.madesubmission1.data.local.db.MyDbHelper
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MovieProvider : ContentProvider(), KodeinAware {

    override val kodein: Kodein by closestKodein(context!!)
    private val myDbHelper: MyDbHelper by instance()

    companion object {
        /** The authority of this content provider.  */
        val AUTHORITY = "com.luteh.madesubmission1.provider"

        /** The URI for the Menu table.  */
        val URI_MOVIE = Uri.parse(
            "content://$AUTHORITY/$DATABASE_TABLE_MOVIE"
        )

        private val MOVIE = 1
        private val MOVIE_ID = 2

        private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    }

    init {
        // content://com.luteh.madesubmission1.provider/movie_db
        sUriMatcher.addURI(AUTHORITY, DATABASE_TABLE_MOVIE, MOVIE)

        // content://com.luteh.madesubmission1.provider/movie_db/id
        sUriMatcher.addURI(
            AUTHORITY,
            "$DATABASE_TABLE_MOVIE/#",
            MOVIE_ID
        )
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val deleted = when (sUriMatcher.match(uri)) {
            MOVIE -> myDbHelper.deleteMovieProvider(ContentUris.parseId(uri))
            else -> 0
        }

        context!!.contentResolver.notifyChange(URI_MOVIE, null)

        return deleted
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        val added = when (sUriMatcher.match(uri)) {
            MOVIE -> myDbHelper.insertMovieProvider(values!!)
            else -> 0
        }

        context!!.contentResolver.notifyChange(URI_MOVIE, null)

        return ContentUris.withAppendedId(URI_MOVIE, added)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        return 0
    }
}
