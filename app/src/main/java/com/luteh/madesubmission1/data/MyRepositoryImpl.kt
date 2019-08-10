package com.luteh.madesubmission1.data

import com.luteh.madesubmission1.data.local.db.MyDbHelper
import com.luteh.madesubmission1.data.local.prefs.PreferencesHelper
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.movierelease.MovieReleaseResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import com.luteh.madesubmission1.data.remote.ApiServiceInterface
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class MyRepositoryImpl(
    private val apiServiceInterface: ApiServiceInterface,
    private val myDbHelper: MyDbHelper,
    private val preferencesHelper: PreferencesHelper
) : MyRepository {
    override fun getMovieById(movieId: Int): Single<MovieData> = myDbHelper.getMovieById(movieId)

    override fun getTvShowById(tvShowId: Int): Single<TvShowData> =
        myDbHelper.getTvShowById(tvShowId)

    override fun getMovieData(language: String): Single<MovieResponse> =
        apiServiceInterface.getMovieData(language)

    override fun saveMovie(movieDb: MovieData): Completable =
        myDbHelper.saveMovie(movieDb)

    override fun loadAllMovies(): Flowable<List<MovieData>> =
        myDbHelper.loadAllMovies()

    override fun deleteMovieById(movieId: Int) =
        myDbHelper.deleteMovieById(movieId)

    override fun saveTvShow(tvShowDb: TvShowData): Completable =
        myDbHelper.saveTvShow(tvShowDb)

    override fun loadAllTvShows(): Flowable<List<TvShowData>> =
        myDbHelper.loadAllTvShows()

    override fun deleteTvShowById(tvShowId: Int) =
        myDbHelper.deleteTvShowById(tvShowId)

    override fun getTvShowData(language: String): Single<TvShowResponse> =
        apiServiceInterface.getTvShowData(language)

    override fun getMovieReleaseData(todayDate: String): Single<MovieReleaseResponse> =
        apiServiceInterface.getMovieReleaseData(todayDate, todayDate)

    override fun isReleaseReminderEnabled(): Boolean =
        preferencesHelper.isReleaseReminderEnabled()

    override fun isDailyReminderEnabled(): Boolean =
        preferencesHelper.isDailyReminderEnabled()
}