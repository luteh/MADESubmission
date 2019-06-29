package com.luteh.madesubmission1.data

import android.content.Context
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.data.model.HomeData

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */
object HomeDataFactory {

    fun getMovieDatas(context: Context): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(setMovieData(context)[(0 until 5).shuffled().first()])
        }

        return homeList
    }

    private fun setMovieData(context: Context): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        homeList.add(
            HomeData(
                R.drawable.poster_avengerinfinity,
                "Avengers: Infinity War",
                "April 23, 2018",
                "English",
                "2h 29m",
                "Adventure, Action, Fantasy",
                context.resources.getStringArray(R.array.caption_overview_movies)[0]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_a_star,
                "A Star Is Born",
                "October 5, 2018",
                "English",
                "2h 15m",
                "Drama, Romance, Music",
                context.resources.getStringArray(R.array.caption_overview_movies)[1]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_aquaman,
                "Aquaman",
                "December 21, 2018",
                "English",
                "2h 24m",
                "Adventure, Action, Fantasy",
                context.resources.getStringArray(R.array.caption_overview_movies)[2]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_birdbox,
                "Bird Box",
                "November 12, 2018",
                "English",
                "2h 4m",
                "Thriller, Drama",
                context.resources.getStringArray(R.array.caption_overview_movies)[3]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_bohemian,
                "Bohemian Rhapsody",
                "October 30, 2018",
                "English",
                "2h 15m",
                "Drama, Music",
                context.resources.getStringArray(R.array.caption_overview_movies)[4]
            )
        )
        return homeList
    }

    fun getTvShowDatas(context: Context): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(setTvShowData(context)[(0 until 5).shuffled().first()])
        }

        return homeList
    }

    private fun setTvShowData(context: Context): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        homeList.add(
            HomeData(
                R.drawable.poster_arrow,
                "Arrow",
                "April 23, 2018",
                "English",
                "2h 29m",
                "Adventure, Action, Fantasy",
                context.resources.getStringArray(R.array.caption_overview_tvshows)[0]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_doom_patrol,
                "Doom Patrol",
                "October 5, 2018",
                "English",
                "2h 15m",
                "Drama, Romance, Music",
                context.resources.getStringArray(R.array.caption_overview_tvshows)[1]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_dragon_ball,
                "Dragon Ball",
                "December 21, 2018",
                "English",
                "2h 24m",
                "Adventure, Action, Fantasy",
                context.resources.getStringArray(R.array.caption_overview_tvshows)[2]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_fairytail,
                "Fairy Tail",
                "November 12, 2018",
                "English",
                "2h 4m",
                "Thriller, Drama",
                context.resources.getStringArray(R.array.caption_overview_tvshows)[3]
            )
        )
        homeList.add(
            HomeData(
                R.drawable.poster_family_guy,
                "Family Guy",
                "October 30, 2018",
                "English",
                "2h 15m",
                "Drama, Music",
                context.resources.getStringArray(R.array.caption_overview_tvshows)[4]
            )
        )
        return homeList
    }
}