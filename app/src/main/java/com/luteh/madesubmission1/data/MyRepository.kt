package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.model.movie.MovieResponse
import com.luteh.madesubmission1.data.model.tvshow.TvShowResponse
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface MyRepository {

    fun getMovieData(language: String): Single<MovieResponse>
    fun getTvShowData(language: String): Single<TvShowResponse>
}