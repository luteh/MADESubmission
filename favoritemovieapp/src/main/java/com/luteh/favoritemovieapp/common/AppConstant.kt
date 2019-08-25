package com.luteh.favoritemovieapp.common

import android.net.Uri

/**
 * Created by Luthfan Maftuh on 8/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
object AppConstant {

    const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w185/"

    const val COLUMN_ID = "id"
    const val COLUMN_TITLE = "title"
    const val COLUMN_VOTE_AVERAGE = "vote_average"
    const val COLUMN_BACKDROP_PATH = "backdrop_path"

    /** The authority of this content provider.  */
    private const val AUTHORITY = "com.luteh.madesubmission1"

    private const val TABLE = "movie_db"

    /** The URI for the Menu table.  */
    val URI_MOVIE = Uri.parse(
        "content://$AUTHORITY/$TABLE"
    )
}