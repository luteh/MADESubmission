package com.luteh.madesubmission1.data.model.api.tvshowsearch


import com.google.gson.annotations.SerializedName

data class TvShowSearchResult(
    @SerializedName("original_name")
    val originalName: String, // The AXI: The Avengers of eXtreme Illusions
    @SerializedName("id")
    val id: Int, // 66848
    @SerializedName("name")
    val name: String, // The AXI: The Avengers of eXtreme Illusions
    @SerializedName("popularity")
    val popularity: Double, // 0.6
    @SerializedName("vote_count")
    val voteCount: Int, // 0
    @SerializedName("vote_average")
    val voteAverage: Int, // 0
    @SerializedName("first_air_date")
    val firstAirDate: String, // 2011-07-15
    @SerializedName("poster_path")
    val posterPath: String?, // /vtRxFVFa4MuhmWtIjbrp1yrxq8g.jpg
    @SerializedName("genre_ids")
    val genreIds: List<Any>,
    @SerializedName("original_language")
    val originalLanguage: String, // en
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /y9FhwCVyIqonm2XqwGrFtmalnkv.jpg
    @SerializedName("overview")
    val overview: String, // Hip-hop dance fuses with psychedelic sci-fi/fantasy in this cutting-edge webseries.
    @SerializedName("origin_country")
    val originCountry: List<Any>
)