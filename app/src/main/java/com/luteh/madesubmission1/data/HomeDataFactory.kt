package com.luteh.madesubmission1.data

import android.content.Context
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.model.HomeData

/**
 * Created by Luthfan Maftuh on 6/24/2019.
 * Email luthfanmaftuh@gmail.com
 */
object HomeDataFactory {

    fun getMovieDatas(): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(setMovieData()[(0 until 5).shuffled().first()])
        }

        return homeList
    }

    private fun setMovieData(): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        homeList.add(
            HomeData(
                R.drawable.poster_avengerinfinity,
                "Avengers: Infinity War",
                "April 23, 2018",
                "English",
                "2h 29m",
                "Adventure, Action, Fantasy",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
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
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
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
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother and true heir to the throne."
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
                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety."
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
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
        )
        return homeList
    }

    fun getTvShowDatas(): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        for (n in 0 until 20) {
            homeList.add(setTvShowData()[(0 until 5).shuffled().first()])
        }

        return homeList
    }

    private fun setTvShowData(): List<HomeData> {
        val homeList: MutableList<HomeData> = mutableListOf()
        homeList.add(
            HomeData(
                R.drawable.poster_arrow,
                "Arrow",
                "April 23, 2018",
                "English",
                "2h 29m",
                "Adventure, Action, Fantasy",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
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
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find."
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
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku\\'s home. Together, they set off to find all seven dragon balls in an adventure that would change Goku\\'s life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT."
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
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail."
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
                "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
            )
        )
        return homeList
    }
}