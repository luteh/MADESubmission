package com.luteh.madesubmission1.data.local

import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.Completable
import io.reactivex.Flowable

class MyDbHelperImpl(private val myDatabase: MyDatabase) : MyDbHelper {
    override fun saveMovie(movieDb: MovieDb): Completable =
        myDatabase.movieDao().insertMovie(movieDb)

    override fun loadAllMovies(): Flowable<List<MovieDb>> =
        myDatabase.movieDao().loadAllMovies()

    override fun deleteMovieById(movieId: String) =
        myDatabase.movieDao().deleteMovieById(movieId)

    override fun saveTvShow(tvShowDb: TvShowDb): Completable =
        myDatabase.tvShowDao().insertTvShow(tvShowDb)

    override fun loadAllTvShows(): Flowable<List<TvShowDb>> =
        myDatabase.tvShowDao().loadAllTvShows()

    override fun deleteTvShowById(tvShowId: String) =
        myDatabase.tvShowDao().deleteTvShowById(tvShowId)
}