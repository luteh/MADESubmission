package com.luteh.madesubmission1.data.model.tvshow


import com.google.gson.annotations.SerializedName

data class TvShowData(
    @SerializedName("original_name")
    val originalName: String, // Supernatural
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("name")
    val name: String, // Supernatural
    @SerializedName("popularity")
    val popularity: Double, // 110.063
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("vote_count")
    val voteCount: Int, // 1812
    @SerializedName("first_air_date")
    val firstAirDate: String, // 2005-09-13
    @SerializedName("backdrop_path")
    val backdropPath: String, // /o9OKe3M06QMLOzTl3l6GStYtnE9.jpg
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("id")
    val id: Int, // 1622
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.3
    @SerializedName("overview")
    val overview: String, // When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.
    @SerializedName("poster_path")
    val posterPath: String // /3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg
)