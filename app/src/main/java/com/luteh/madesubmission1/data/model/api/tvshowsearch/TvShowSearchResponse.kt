package com.luteh.madesubmission1.data.model.api.tvshowsearch


import com.google.gson.annotations.SerializedName

data class TvShowSearchResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("total_results")
    val totalResults: Int, // 14
    @SerializedName("total_pages")
    val totalPages: Int, // 1
    @SerializedName("results")
    val results: List<TvShowSearchResult>
)