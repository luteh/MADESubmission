package com.luteh.madesubmission1.data.local

import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface MyDbHelper {

    fun saveMovie(movieDb: MovieDb): Completable
    fun loadAllMovies(): Flowable<List<MovieDb>>
    fun deleteMovieById(movieId: String)

    fun saveTvShow(tvShowDb: TvShowDb): Completable
    fun loadAllTvShows(): Flowable<List<TvShowDb>>
    fun deleteTvShowById(tvShowId: String)
}