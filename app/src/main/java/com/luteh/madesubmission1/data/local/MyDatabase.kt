package com.luteh.madesubmission1.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.luteh.madesubmission1.common.constant.AppConstant.DATABASE_NAME
import com.luteh.madesubmission1.data.local.dao.MovieDao
import com.luteh.madesubmission1.data.local.dao.TvShowDao
import com.luteh.madesubmission1.data.model.db.MovieDb
import com.luteh.madesubmission1.data.model.db.TvShowDb

/**
 * Created by Luthfan Maftuh on 7/5/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Database(entities = [MovieDb::class, TvShowDb::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

    companion object {
        operator fun invoke(context: Context): MyDatabase =
            Room.databaseBuilder(
                context,
                MyDatabase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}