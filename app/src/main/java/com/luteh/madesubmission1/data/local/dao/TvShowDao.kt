package com.luteh.madesubmission1.data.local.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luteh.madesubmission1.data.model.db.TvShowData
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShowDb: TvShowData): Completable

    @Query("SELECT * FROM tv_show_db WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: Int): Single<TvShowData>

    @Query("SELECT * FROM tv_show_db")
    fun loadAllTvShows(): DataSource.Factory<Int, TvShowData>

    @Query("DELETE FROM tv_show_db WHERE id = :tvShowId")
    fun deleteTvShowById(tvShowId: Int): Completable
}