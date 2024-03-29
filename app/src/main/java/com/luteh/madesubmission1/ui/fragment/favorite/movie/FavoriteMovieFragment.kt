package com.luteh.madesubmission1.ui.fragment.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter.FavoriteMovieAdapter
import com.luteh.madesubmission1.ui.fragment.favorite.movie.adapter.FavoriteMovieItemListener
import kotlinx.android.synthetic.main.common_loading.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.no_data_item.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Luthfan Maftuh on 7/10/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteMovieFragment : BaseFragment(), FavoriteMovieItemListener, FavoriteMovieNavigator {

    private lateinit var viewModel: FavoriteMovieViewModel

    private val movieAdapter = FavoriteMovieAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
        setupRecyclerView()

        viewModel.loadAllMovies()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FavoriteMovieViewModel::class.java)
        viewModel.mNavigator = this

        viewModel.mIsLoading.observe(this, Observer {
            if (it) {
                pb_common_loading.visibility = VISIBLE
                rv_main.visibility = INVISIBLE
            } else {
                pb_common_loading.visibility = INVISIBLE
                rv_main.visibility = VISIBLE
            }
        })

        viewModel.movieDataList.observe(this, Observer {
            layout_no_data_item_container.visibility =
                if (it.isNullOrEmpty()) VISIBLE else INVISIBLE

            movieAdapter.setDataSource(it)
        })
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    override fun onItemClicked(data: MovieData) {
        startActivity<DetailActivity>(AppConstant.KEY_BUNDLE_HOME_DATA to data)
    }
}