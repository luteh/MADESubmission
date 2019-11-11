package com.luteh.madesubmission1.ui.fragment.favorite.movie

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.local.MyDbHelper
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.utils.FakeDataFactoryUnitTest
import com.luteh.madesubmission1.utils.PagedListUtil
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

/**
 * Created by Luthfan Maftuh on 11/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieViewModelTest {
    @Mock
    private lateinit var myRepository: MyRepository

    @Mock
    private lateinit var myDbHelper: MyDbHelper


    private lateinit var viewModel: FavoriteMovieViewModel

    private val movieEntities = FakeDataFactoryUnitTest.getMovieDatas()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = FavoriteMovieViewModel(myRepository)
    }

    @Test
    fun loadAllMovies() {
        val dataSourceFactory: DataSource.Factory<*, *> = mock(DataSource.Factory::class.java)
        val movieDatas: LiveData<PagedList<MovieData>> = viewModel.loadAllMovies()

        `when`(myDbHelper.loadAllMovies()).thenReturn(dataSourceFactory as DataSource.Factory<Int, MovieData>)

        `when`(myRepository.loadAllMovies()).thenReturn(movieDatas)


        val result = PagedListUtil.mockPagedList(movieEntities)
        assertNotNull(result)
    }
}