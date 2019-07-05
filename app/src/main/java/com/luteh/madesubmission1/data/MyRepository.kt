package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface MyRepository {

    fun getMovieData(language: String): Single<MovieResponse>
    fun getTvShowData(language: String): Single<TvShowResponse>
}