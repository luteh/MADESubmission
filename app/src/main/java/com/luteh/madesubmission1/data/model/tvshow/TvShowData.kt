package com.luteh.madesubmission1.data.model.tvshow


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

data class TvShowData(
    @SerializedName("original_name")
    val originalName: String?, // Supernatural
    @SerializedName("genre_ids")
    val genreIds: IntArray?,
    @SerializedName("name")
    val name: String?, // Supernatural
    @SerializedName("popularity")
    val popularity: Double, // 110.063
    @SerializedName("origin_country")
    val originCountry: ArrayList<String>?,
    @SerializedName("vote_count")
    val voteCount: Int, // 1812
    @SerializedName("first_air_date")
    val firstAirDate: String?, // 2005-09-13
    @SerializedName("backdrop_path")
    val backdropPath: String?, // /o9OKe3M06QMLOzTl3l6GStYtnE9.jpg
    @SerializedName("original_language")
    val originalLanguage: String?, // en
    @SerializedName("id")
    val id: Int, // 1622
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.3
    @SerializedName("overview")
    val overview: String?, // When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.
    @SerializedName("poster_path")
    val posterPath: String? // /3iFm6Kz7iYoFaEcj4fLyZHAmTQA.jpg
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createIntArray(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.createStringArrayList(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(originalName)
        parcel.writeIntArray(genreIds)
        parcel.writeString(name)
        parcel.writeDouble(popularity)
        parcel.writeStringList(originCountry)
        parcel.writeInt(voteCount)
        parcel.writeString(firstAirDate)
        parcel.writeString(backdropPath)
        parcel.writeString(originalLanguage)
        parcel.writeInt(id)
        parcel.writeDouble(voteAverage)
        parcel.writeString(overview)
        parcel.writeString(posterPath)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TvShowData

        if (originalName != other.originalName) return false
        if (genreIds != null) {
            if (other.genreIds == null) return false
            if (!genreIds.contentEquals(other.genreIds)) return false
        } else if (other.genreIds != null) return false
        if (name != other.name) return false
        if (popularity != other.popularity) return false
        if (originCountry != other.originCountry) return false
        if (voteCount != other.voteCount) return false
        if (firstAirDate != other.firstAirDate) return false
        if (backdropPath != other.backdropPath) return false
        if (originalLanguage != other.originalLanguage) return false
        if (id != other.id) return false
        if (voteAverage != other.voteAverage) return false
        if (overview != other.overview) return false
        if (posterPath != other.posterPath) return false

        return true
    }

    override fun hashCode(): Int {
        var result = originalName?.hashCode() ?: 0
        result = 31 * result + (genreIds?.contentHashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + popularity.hashCode()
        result = 31 * result + (originCountry?.hashCode() ?: 0)
        result = 31 * result + voteCount
        result = 31 * result + (firstAirDate?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + id
        result = 31 * result + voteAverage.hashCode()
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        return result
    }

    companion object CREATOR : Parcelable.Creator<TvShowData> {
        override fun createFromParcel(parcel: Parcel): TvShowData {
            return TvShowData(parcel)
        }

        override fun newArray(size: Int): Array<TvShowData?> {
            return arrayOfNulls(size)
        }
    }
}