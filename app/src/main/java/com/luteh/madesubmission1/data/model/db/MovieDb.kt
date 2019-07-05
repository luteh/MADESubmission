package com.luteh.madesubmission1.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Luthfan Maftuh on 7/4/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Entity(tableName = "movie_db")
data class MovieDb(
    @PrimaryKey
    val id: Int, // 532321
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double, // 5.5
    val title: String?, // Re: Zero kara Hajimeru Isekai Seikatsu - Memory Snow
    val popularity: Double, // 81.084
    @ColumnInfo(name = "poster_path")
    val posterPath: String?, // /xqR4ABkFTFYe8NDJi3knwWX7zfn.jpg
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?, // ja
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?, // /8sNz2DxYiYqGkxk66U8BqvuZZjE.jpg
    val overview: String?, // Subaru and friends finally get a moment of peace, and Subaru goes on a certain secret mission that he must not let anyone find out about! However, even though Subaru is wearing a disguise, Petra and other children of the village immediately figure out who he is. Now that his mission was exposed within five seconds of it starting, what will happen with Subaru's "date course" with Emilia?
    @ColumnInfo(name = "release_date")
    val releaseDate: String?, // 2018-10-06
    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean
)