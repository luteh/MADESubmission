package com.luteh.madesubmission1.ui.fragment.movies

import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.api.movie.MovieResponse
import com.luteh.madesubmission1.ui.fragment.discover.movies.DiscoverMovieViewModel
import io.reactivex.Single
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


/**
 * Created by Luthfan Maftuh on 10/6/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DiscoverMovieViewModelTest {

    @Mock
    private lateinit var myRepository: MyRepository

    private lateinit var viewModel: DiscoverMovieViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DiscoverMovieViewModel(myRepository)
    }

    @Test
    fun fetchMovieData() {
        `when`(myRepository.getMovieData("en-US")).thenReturn(
            Single.just(
                MovieResponse(
                    0,
                    0,
                    0,
                    emptyList()
                )
            )
        )

        viewModel.getMovieData("en-US")

        assertNotNull(viewModel.movieDatas)
    }
}