package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.movierelease.MovieReleaseResponse
import com.luteh.madesubmission1.data.model.api.moviesearch.MovieSearchResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.model.api.tvshowsearch.TvShowSearchResponse
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
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

    fun saveMovie(movieDb: MovieData): Completable
    fun getMovieById(movieId: Int): Single<MovieData>
    fun loadAllMovies(): Flowable<List<MovieData>>
    fun deleteMovieById(movieId: Int): Completable

    fun saveTvShow(tvShowDb: TvShowData): Completable
    fun getTvShowById(tvShowId: Int): Single<TvShowData>
    fun loadAllTvShows(): Flowable<List<TvShowData>>
    fun deleteTvShowById(tvShowId: Int): Completable

    fun isReleaseReminderEnabled(): Boolean
    fun isDailyReminderEnabled(): Boolean

    fun getMovieReleaseData(todayDate: String): Single<MovieReleaseResponse>

    fun searchMovie(query: String): Single<MovieSearchResponse>
    fun searchTvShow(query: String): Single<TvShowSearchResponse>
}