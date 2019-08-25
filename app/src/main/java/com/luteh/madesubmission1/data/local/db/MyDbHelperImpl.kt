package com.luteh.madesubmission1.data.local.db

import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class MyDbHelperImpl(private val myDatabase: MyDatabase) :
    MyDbHelper {
    override fun getMovieById(movieId: Int): Single<MovieData> =
        myDatabase.movieDao().getMovieById(movieId)

    override fun getTvShowById(tvShowId: Int): Single<TvShowData> =
        myDatabase.tvShowDao().getTvShowById(tvShowId)

    override fun saveMovie(movieDb: MovieData): Completable =
        myDatabase.movieDao().insertMovie(movieDb)

    override fun loadAllMovies(): Flowable<List<MovieData>> =
        myDatabase.movieDao().loadAllMovies()

    override fun deleteMovieById(movieId: Int) =
        myDatabase.movieDao().deleteMovieById(movieId)

    override fun saveTvShow(tvShowDb: TvShowData): Completable =
        myDatabase.tvShowDao().insertTvShow(tvShowDb)

    override fun loadAllTvShows(): Flowable<List<TvShowData>> =
        myDatabase.tvShowDao().loadAllTvShows()

    override fun deleteTvShowById(tvShowId: Int) =
        myDatabase.tvShowDao().deleteTvShowById(tvShowId)
}