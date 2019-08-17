package com.luteh.madesubmission1.data.model.api.moviesearch


import com.google.gson.annotations.SerializedName
import com.luteh.madesubmission1.data.model.db.MovieData

data class MovieSearchResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("total_results")
    val totalResults: Int, // 142
    @SerializedName("total_pages")
    val totalPages: Int, // 8
    @SerializedName("results")
    val results: List<MovieData>
)