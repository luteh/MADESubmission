package com.luteh.madesubmission1.data.model.movie


import com.google.gson.annotations.SerializedName

data class MovieData(
    @SerializedName("vote_count")
    val voteCount: Int, // 28
    @SerializedName("id")
    val id: Int, // 532321
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 5.5
    @SerializedName("title")
    val title: String, // Re: Zero kara Hajimeru Isekai Seikatsu - Memory Snow
    @SerializedName("popularity")
    val popularity: Double, // 81.084
    @SerializedName("poster_path")
    val posterPath: String, // /xqR4ABkFTFYe8NDJi3knwWX7zfn.jpg
    @SerializedName("original_language")
    val originalLanguage: String, // ja
    @SerializedName("original_title")
    val originalTitle: String, // Re:ゼロから始める異世界生活 Memory Snow
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("backdrop_path")
    val backdropPath: String, // /8sNz2DxYiYqGkxk66U8BqvuZZjE.jpg
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("overview")
    val overview: String, // Subaru and friends finally get a moment of peace, and Subaru goes on a certain secret mission that he must not let anyone find out about! However, even though Subaru is wearing a disguise, Petra and other children of the village immediately figure out who he is. Now that his mission was exposed within five seconds of it starting, what will happen with Subaru's "date course" with Emilia?
    @SerializedName("release_date")
    val releaseDate: String // 2018-10-06
)