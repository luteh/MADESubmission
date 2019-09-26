package com.luteh.madesubmission1.ui.fragment.tvshow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShowDatas() {
        val tvShowDatas = viewModel.getTvShowDatas()

        assertNotNull(tvShowDatas)
        assertEquals(20, tvShowDatas.size)
    }
}