package com.luteh.madesubmission1.data.local

import androidx.paging.DataSource
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface MyDbHelper {

    fun saveMovie(movieDb: MovieData): Completable
    fun getMovieById(movieId: Int): Single<MovieData>
    fun loadAllMovies(): DataSource.Factory<Int, MovieData>
    fun deleteMovieById(movieId: Int): Completable

    fun saveTvShow(tvShowDb: TvShowData): Completable
    fun getTvShowById(tvShowId: Int): Single<TvShowData>
    fun loadAllTvShows(): DataSource.Factory<Int, TvShowData>
    fun deleteTvShowById(tvShowId: Int): Completable
}