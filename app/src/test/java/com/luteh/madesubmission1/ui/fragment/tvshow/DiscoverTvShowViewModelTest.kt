package com.luteh.madesubmission1.ui.fragment.tvshow

import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowResponse
import com.luteh.madesubmission1.ui.fragment.discover.tvshow.DiscoverTvShowViewModel
import io.reactivex.Single
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Luthfan Maftuh on 10/27/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DiscoverTvShowViewModelTest {
    @Mock
    private lateinit var myRepository: MyRepository

    private lateinit var viewModel: DiscoverTvShowViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DiscoverTvShowViewModel(myRepository)
    }

    @Test
    fun fetchMovieData() {
        `when`(myRepository.getTvShowData("en-US")).thenReturn(
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