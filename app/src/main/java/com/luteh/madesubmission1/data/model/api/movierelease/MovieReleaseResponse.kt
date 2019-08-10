package com.luteh.madesubmission1.data.model.api.movierelease


import com.google.gson.annotations.SerializedName

data class MovieReleaseResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("total_results")
    val totalResults: Int, // 21
    @SerializedName("total_pages")
    val totalPages: Int, // 2
    @SerializedName("results")
    val results: List<Result>
)