package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.local.MyDbHelper
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb
import com.luteh.madesubmission1.data.remote.ApiServiceInterface
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class MyRepositoryImpl(
    private val apiServiceInterface: ApiServiceInterface,
    private val myDbHelper: MyDbHelper
) : MyRepository {

    override fun getMovieData(language: String): Single<MovieResponse> =
        apiServiceInterface.getMovieData(language)

    override fun saveMovie(movieDb: MovieDb): Completable =
        myDbHelper.saveMovie(movieDb)

    override fun loadAllMovies(): Flowable<List<MovieDb>> =
        myDbHelper.loadAllMovies()

    override fun deleteMovieById(movieId: String) =
        myDbHelper.deleteMovieById(movieId)

    override fun saveTvShow(tvShowDb: TvShowDb): Completable =
        myDbHelper.saveTvShow(tvShowDb)

    override fun loadAllTvShows(): Flowable<List<TvShowDb>> =
        myDbHelper.loadAllTvShows()

    override fun deleteTvShowById(tvShowId: String) =
        myDbHelper.deleteTvShowById(tvShowId)

    override fun getTvShowData(language: String): Single<TvShowResponse> =
        apiServiceInterface.getTvShowData(language)
}