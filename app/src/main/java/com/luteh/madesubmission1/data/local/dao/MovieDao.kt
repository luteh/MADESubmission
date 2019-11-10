package com.luteh.madesubmission1.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luteh.madesubmission1.data.model.db.MovieData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieDb: MovieData): Completable

    @Query("SELECT * FROM movie_db WHERE id = :movieId")
    fun getMovieById(movieId: Int): Single<MovieData>

    @Query("SELECT * FROM movie_db")
    fun loadAllMovies(): DataSource.Factory<Int, MovieData>

    @Query("DELETE FROM movie_db WHERE id = :movieId")
    fun deleteMovieById(movieId: Int): Completable
}