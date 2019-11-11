package com.luteh.madesubmission1.utils

import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData

/**
 * Created by Luthfan Maftuh on 11/2/2019.
 * Email luthfanmaftuh@gmail.com
 */
object FakeDataFactoryUnitTest {
    fun getMovieDatas(): List<MovieData> {
        val homeList: MutableList<MovieData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(
                MovieData(
                    4556,
                    475557,
                    false,
                    8.5,
                    "Joker",
                    470.723,
                    "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                    "en",
                    "Joker",
                    "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                    false,
                    "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                    "2019-10-04"
                )
            )
        }

        return homeList
    }

    fun getTvShows(): List<TvShowData> {
        val homeList: MutableList<TvShowData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(
                TvShowData(
                    "Supernatural",
                    "Supernatural",
                    378.877,
                    listOf("US"),
                    2024,
                    "2005-09-13",
                    "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
                    "en",
                    1622,
                    7.4,
                    "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way. ",
                    "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg"
                )
            )
        }

        return homeList
    }
}