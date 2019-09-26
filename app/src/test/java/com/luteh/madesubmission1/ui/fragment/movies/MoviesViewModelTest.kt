package com.luteh.madesubmission1.ui.fragment.movies

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovieDatas() {
        val movieDatas =
            viewModel.getMovieDatas()

        assertNotNull(movieDatas)
        assertEquals(20, movieDatas.size)
    }
}