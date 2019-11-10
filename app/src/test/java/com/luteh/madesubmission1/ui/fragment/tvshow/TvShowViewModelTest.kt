package com.luteh.madesubmission1.ui.fragment.tvshow

import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.tvshow.TvShowResponse
import io.reactivex.Single
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by Luthfan Maftuh on 10/27/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowViewModelTest {
    @Mock
    private lateinit var myRepository: MyRepository

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TvShowViewModel(myRepository)
    }

    @Test
    fun fetchMovieData() {
        Mockito.`when`(myRepository.getTvShowData("en-US")).thenReturn(
            Single.just(
                TvShowResponse(
                    0,
                    0,
                    0,
                    emptyList()
                )
            )
        )

        viewModel.getTvShowData("en-US")

        assertNotNull(viewModel.tvShowDatas)
    }
}