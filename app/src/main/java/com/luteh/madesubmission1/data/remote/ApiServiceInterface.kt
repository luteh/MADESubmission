package com.luteh.madesubmission1.data.remote

import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.data.model.api.movierelease.MovieReleaseResponse
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
interface ApiServiceInterface {

    // 3/discover/movie?api_key={API KEY}&language=en-US
    @GET(ApiEndPoint.ENDPOINT_MOVIE_DATA)
    fun getMovieData(
        @Query("language") language: String
    ): Single<MovieResponse>

    // 3/discover/tv?api_key={API KEY}&language=en-US
    @GET(ApiEndPoint.ENDPOINT_TV_SHOW_DATA)
    fun getTvShowData(
        @Query("language") language: String
    ): Single<TvShowResponse>

    // 3/discover/movie?api_key={API KEY}&primary_release_date.gte={TODAY DATE}&primary_release_date.lte={TODAY DATE}
    @GET(ApiEndPoint.ENDPOINT_MOVIE_DATA)
    fun getMovieReleaseData(
        @Query("primary_release_date.gte") todayDate: String,
        @Query("primary_release_date.lte") todayDate2: String

    ): Single<MovieReleaseResponse>

    companion object {
        operator fun invoke(): ApiServiceInterface {

            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", AppConstant.API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServiceInterface::class.java)
        }
    }
}