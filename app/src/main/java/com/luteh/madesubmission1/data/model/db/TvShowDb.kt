package com.luteh.madesubmission1.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.luteh.madesubmission1.common.constant.AppConstant.DATABASE_TABLE_TV_SHOW

/**
 * Created by Luthfan Maftuh on 7/4/2019.
 * Email luthfanmaftuh@gmail.com
 */
@Entity(tableName = DATABASE_TABLE_TV_SHOW)
data class TvShowDb(
    val name: String?, // Supernatural
    val popularity: Double, // 110.063
    @ColumnInfo(name = "first_air_date")
    val firstAirDate: String?, // 2005-09-13
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?, // /o9OKe3M06QMLOzTl3l6GStYtnE9.jpg
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?, // en
    @PrimaryKey
    val id: Int, // 1622
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double, // 7.3
    val overview: String?, // When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.
    @ColumnInfo(name = "poster_path")
    val posterPath: String?, // /3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg
    @ColumnInfo(name = "is_liked")
    val isLiked: Boolean
)