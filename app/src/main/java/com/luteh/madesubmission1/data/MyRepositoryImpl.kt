package com.luteh.madesubmission1.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.luteh.madesubmission1.common.constant.AppConstant.PAGE_SIZE
import com.luteh.madesubmission1.data.local.MyDbHelper
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import com.luteh.madesubmission1.data.remote.ApiServiceInterface
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class MyRepositoryImpl(
    private val apiServiceInterface: ApiServiceInterface,
    private val myDbHelper: MyDbHelper
) : MyRepository {
    override fun getMovieById(movieId: Int): Single<MovieData> = myDbHelper.getMovieById(movieId)

    override fun getTvShowById(tvShowId: Int): Single<TvShowData> =
        myDbHelper.getTvShowById(tvShowId)

    override fun getMovieData(language: String): Single<MovieResponse> =
        apiServiceInterface.getMovieData(language)

    override fun saveMovie(movieDb: MovieData): Completable =
        myDbHelper.saveMovie(movieDb)

    override fun loadAllMovies(): LiveData<PagedList<MovieData>> =
        LivePagedListBuilder(myDbHelper.loadAllMovies(), PAGE_SIZE).build()

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
}