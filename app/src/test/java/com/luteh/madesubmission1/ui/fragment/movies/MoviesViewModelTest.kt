package com.luteh.madesubmission1.ui.fragment.movies

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

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