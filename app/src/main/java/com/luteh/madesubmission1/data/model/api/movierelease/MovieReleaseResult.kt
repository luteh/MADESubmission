package com.luteh.madesubmission1.data.model.api.movierelease


import com.google.gson.annotations.SerializedName

data class MovieReleaseResult(
    @SerializedName("vote_count")
    val voteCount: Int, // 0
    @SerializedName("id")
    val id: Int, // 616062
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Int, // 0
    @SerializedName("title")
    val title: String, // Fallen Hearts
    @SerializedName("popularity")
    val popularity: Double, // 2.744
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("original_title")
    val originalTitle: String, // Fallen Hearts
    @SerializedName("genre_ids")
    val genreIds: List<Any>,
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("overview")
    val overview: String, // Heaven is now happily married and ready to settle back in her hometown. But after a trip to Farthinggale Manor, Heaven is persuaded to stay. Lured by her grandfather to live amidst the wealthy and privileged Heaven seems to have it all until the ghosts of her past rise up once more, threatening her precious new life.
    @SerializedName("release_date")
    val releaseDate: String, // 2019-08-10
    @SerializedName("poster_path")
    val posterPath: String?, // /c5sRD6Cb3jZj8elqTUcoP4R95IS.jpg
    @SerializedName("backdrop_path")
    val backdropPath: String? // /xYACG87Jzy261S0sv6WOmsFKgKX.jpg
)