package com.luteh.madesubmission1.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
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
    fun loadAllMovies(): LiveData<PagedList<MovieData>>
    fun deleteMovieById(movieId: Int): Completable

    fun saveTvShow(tvShowDb: TvShowData): Completable
    fun getTvShowById(tvShowId: Int): Single<TvShowData>
    fun loadAllTvShows(): LiveData<PagedList<TvShowData>>
    fun deleteTvShowById(tvShowId: Int): Completable
}