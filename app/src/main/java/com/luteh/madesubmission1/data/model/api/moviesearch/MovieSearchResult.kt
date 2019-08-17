package com.luteh.madesubmission1.data.model.api.moviesearch


import com.google.gson.annotations.SerializedName

data class MovieSearchResult(
    @SerializedName("popularity")
    val popularity: Double, // 6.538
    @SerializedName("id")
    val id: Int, // 257346
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_count")
    val voteCount: Int, // 103
    @SerializedName("vote_average")
    val voteAverage: Double, // 5.8
    @SerializedName("title")
    val title: String, // Avengers Confidential: Black Widow & Punisher
    @SerializedName("release_date")
    val releaseDate: String, // 2014-03-25
    @SerializedName("original_language")
    val originalLanguage: String, // ja
    @SerializedName("original_title")
    val originalTitle: String, // アベンジャーズ コンフィデンシャル：ブラック・ウィドウ ＆ パニッシャー
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /kI1AdjSl2o038FQRZTuOqOlZ9VN.jpg
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("overview")
    val overview: String, // When the Punisher takes out a black-market weapons dealer, he stumbles upon a far-reaching terrorist plot devised by a group known as Leviathan.
    @SerializedName("poster_path")
    val posterPath: String? // /6zBkbmqB857edSNt08fJpv1Tqqt.jpg
)