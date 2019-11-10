package com.luteh.madesubmission1.utils

import com.luteh.madesubmission1.data.model.movie.MovieData

/**
 * Created by Luthfan Maftuh on 11/2/2019.
 * Email luthfanmaftuh@gmail.com
 */
object FakeDataFactory {
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
                    intArrayOf(80, 18, 53),
                    "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                    false,
                    "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                    "2019-10-04"
                )
            )
        }

        return homeList
    }
}