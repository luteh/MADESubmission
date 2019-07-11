package com.luteh.madesubmission1.data.model.api.tvshow


import com.google.gson.annotations.SerializedName
import com.luteh.madesubmission1.data.model.db.TvShowData

data class TvShowResponse(
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("total_results")
    val totalResults: Int, // 82647
    @SerializedName("total_pages")
    val totalPages: Int, // 4133
    @SerializedName("results")
    val tvShowData: List<TvShowData>
)