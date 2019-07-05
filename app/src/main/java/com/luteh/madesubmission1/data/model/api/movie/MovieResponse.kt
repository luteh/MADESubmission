package com.luteh.madesubmission1.data.model.api.movie


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("total_results")
    val totalResults: Int, // 423016
    @SerializedName("total_pages")
    val totalPages: Int, // 21151
    @SerializedName("results")
    val movieData: List<MovieData>
)