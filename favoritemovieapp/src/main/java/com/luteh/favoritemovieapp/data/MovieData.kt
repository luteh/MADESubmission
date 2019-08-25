package com.luteh.favoritemovieapp.data

import android.database.Cursor
import com.luteh.favoritemovieapp.common.AppConstant.COLUMN_BACKDROP_PATH
import com.luteh.favoritemovieapp.common.AppConstant.COLUMN_ID
import com.luteh.favoritemovieapp.common.AppConstant.COLUMN_TITLE
import com.luteh.favoritemovieapp.common.AppConstant.COLUMN_VOTE_AVERAGE

/**
 * Created by Luthfan Maftuh on 8/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
data class MovieData(
    val id: Int, // 532321
    val voteAverage: Double, // 5.5
    val title: String?, // Re: Zero kara Hajimeru Isekai Seikatsu - Memory Snow
    val backdropPath: String? // /8sNz2DxYiYqGkxk66U8BqvuZZjE.jpg
) {
    companion object {
        fun fromCursor(cursor: Cursor): MovieData {
            val id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE))
            val voteAverage = cursor.getDouble(cursor.getColumnIndex(COLUMN_VOTE_AVERAGE))
            val backdropPath = cursor.getString(cursor.getColumnIndex(COLUMN_BACKDROP_PATH))

            return MovieData(id, voteAverage, title, backdropPath)
        }
    }
}