package com.luteh.madesubmission1.ui.fragment.movies

import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.movie.MovieResponse
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations


/**
 * Created by Luthfan Maftuh on 10/6/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MovieViewModelTest {

    @Mock
    private lateinit var myRepository: MyRepository

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MovieViewModel(myRepository)
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
//        assert
//        assertEquals(20, viewModel.movieDatas.value?.size)
    }
}