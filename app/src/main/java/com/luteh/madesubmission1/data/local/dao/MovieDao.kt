package com.luteh.madesubmission1.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luteh.madesubmission1.data.model.db.MovieDb
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movieDb: MovieDb): Completable

    @Query("SELECT * FROM movie_db")
    fun loadAllMovies(): Flowable<List<MovieDb>>

    @Query("DELETE FROM movie_db WHERE id = :movieId")
    fun deleteMovieById(movieId: String)
}