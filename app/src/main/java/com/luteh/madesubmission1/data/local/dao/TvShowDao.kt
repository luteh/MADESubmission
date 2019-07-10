package com.luteh.madesubmission1.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luteh.madesubmission1.data.model.db.TvShowDb
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowDb: TvShowDb): Completable

    @Query("SELECT * FROM tv_show_db WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: Int): Single<TvShowDb>

    @Query("SELECT * FROM tv_show_db")
    fun loadAllTvShows(): Flowable<List<TvShowDb>>

    @Query("DELETE FROM tv_show_db WHERE id = :tvShowId")
    fun deleteTvShowById(tvShowId: Int): Completable
}