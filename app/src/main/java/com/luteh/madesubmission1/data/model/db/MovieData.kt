package com.luteh.madesubmission1.data.model.db


import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.luteh.madesubmission1.common.constant.AppConstant

@Entity(tableName = AppConstant.DATABASE_TABLE_MOVIE)
data class MovieData(
    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int, // 28
    @SerializedName("id")
    @PrimaryKey
    val id: Int, // 532321
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double, // 5.5
    @SerializedName("title")
    val title: String?, // Re: Zero kara Hajimeru Isekai Seikatsu - Memory Snow
    @SerializedName("popularity")
    val popularity: Double, // 81.084
    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String?, // /xqR4ABkFTFYe8NDJi3knwWX7zfn.jpg
    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String?, // ja
    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTitle: String?, // Re:ゼロから始める異世界生活 Memory Snow
    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?, // /8sNz2DxYiYqGkxk66U8BqvuZZjE.jpg
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("overview")
    val overview: String?, // Subaru and friends finally get a moment of peace, and Subaru goes on a certain secret mission that he must not let anyone find out about! However, even though Subaru is wearing a disguise, Petra and other children of the village immediately figure out who he is. Now that his mission was exposed within five seconds of it starting, what will happen with Subaru's "date course" with Emilia?
    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String? // 2018-10-06
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(voteCount)
        parcel.writeInt(id)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeString(title)
        parcel.writeDouble(popularity)
        parcel.writeString(posterPath)
        parcel.writeString(originalLanguage)
        parcel.writeString(originalTitle)
        parcel.writeString(backdropPath)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieData

        if (voteCount != other.voteCount) return false
        if (id != other.id) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (title != other.title) return false
        if (popularity != other.popularity) return false
        if (posterPath != other.posterPath) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (backdropPath != other.backdropPath) return false
        if (adult != other.adult) return false
        if (overview != other.overview) return false
        if (releaseDate != other.releaseDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = voteCount
        result = 31 * result + id
        result = 31 * result + video.hashCode()
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + (originalTitle?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + adult.hashCode()
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (releaseDate?.hashCode() ?: 0)
        return result
    }

    companion object CREATOR : Parcelable.Creator<MovieData> {
        override fun createFromParcel(parcel: Parcel): MovieData {
            return MovieData(parcel)
        }

        override fun newArray(size: Int): Array<MovieData?> {
            return arrayOfNulls(size)
        }
    }
}