package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface MyRepository {

    fun getMovieData(language: String): Single<MovieResponse>
    fun getTvShowData(language: String): Single<TvShowResponse>

    fun saveMovie(movieDb: MovieDb): Completable
    fun loadAllMovies(): Flowable<List<MovieDb>>
    fun deleteMovieById(movieId: String)

    fun saveTvShow(tvShowDb: TvShowDb): Completable
    fun loadAllTvShows(): Flowable<List<TvShowDb>>
    fun deleteTvShowById(tvShowId: String)
}