package com.luteh.madesubmission1.data.local

import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData
import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class MyDbHelperImpl(private val myDatabase: MyDatabase) : MyDbHelper {
    override fun getMovieById(movieId: Int): Single<MovieDb> =
        myDatabase.movieDao().getMovieById(movieId)

    override fun getTvShowById(tvShowId: Int): Single<TvShowData> =
        myDatabase.tvShowDao().getTvShowById(tvShowId)

    override fun saveMovie(movieDb: MovieDb): Completable =
        myDatabase.movieDao().insertMovie(movieDb)

    override fun loadAllMovies(): Flowable<List<MovieDb>> =
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