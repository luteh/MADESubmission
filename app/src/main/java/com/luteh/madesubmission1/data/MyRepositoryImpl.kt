package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.remote.ApiServiceInterface
import io.reactivex.Single

class MyRepositoryImpl(private val apiServiceInterface: ApiServiceInterface) : MyRepository {

    override fun getMovieData(language: String): Single<MovieResponse> =
        apiServiceInterface.getMovieData(language)

    override fun getTvShowData(language: String): Single<TvShowResponse> =
        apiServiceInterface.getTvShowData(language)
}