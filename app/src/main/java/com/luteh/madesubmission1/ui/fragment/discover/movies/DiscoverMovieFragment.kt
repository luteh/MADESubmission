package com.luteh.madesubmission1.ui.fragment.discover.movies


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Commons
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_ENGLISH
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.fragment.discover.movies.adapter.MovieAdapter
import com.luteh.madesubmission1.ui.fragment.discover.movies.adapter.OnMovieItemClickListener
import kotlinx.android.synthetic.main.common_loading.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.no_connection.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 *
 */

private lateinit var viewModel: DiscoverMovieViewModel

class DiscoverMovieFragment : BaseFragment(), OnMovieItemClickListener, DiscoverMovieNavigator {

    private val TAG = "DiscoverMovieFragment"


    private val movieAdapter = MovieAdapter()

    companion object {
        fun searchMovie(query: String?) {
            if (query.isNullOrEmpty())
                viewModel.getMovieData(Commons.currentLanguage.value ?: LANGUAGE_CODE_ENGLISH)
            else
                viewModel.searchMovie(query)
        }
    }

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

        viewModel.getMovieData(Commons.currentLanguage.value ?: LANGUAGE_CODE_ENGLISH)

        Commons.currentLanguage.observe(this, androidx.lifecycle.Observer {
            Log.d(TAG, "onActivityCreated: $it")
            viewModel.getMovieData(it)
        })

        btn_no_connection_retry.setOnClickListener {
            layout_no_connection_container.visibility = View.INVISIBLE
            viewModel.getMovieData(Commons.currentLanguage.value ?: LANGUAGE_CODE_ENGLISH)
        }
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DiscoverMovieViewModel::class.java)
        viewModel.mNavigator = this

        viewModel.mIsLoading.observe(this, androidx.lifecycle.Observer {
            if (it) {
                pb_common_loading.visibility = View.VISIBLE
                rv_main.visibility = View.INVISIBLE
                layout_no_connection_container.visibility = View.INVISIBLE
            } else {
                pb_common_loading.visibility = View.INVISIBLE
                rv_main.visibility = View.VISIBLE
            }
        })

        viewModel.movieDatas.observe(this, androidx.lifecycle.Observer {
            movieAdapter.setDataSource(it)
        })
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        movieAdapter.setItemClickListener(this@DiscoverMovieFragment)
    }

    override fun onItemClicked(data: MovieData) {
        startActivity<DetailActivity>(AppConstant.KEY_BUNDLE_HOME_DATA to data)
    }

    override fun onErrorGetMovieData() {
        layout_no_connection_container.visibility = View.VISIBLE
        rv_main.visibility = View.INVISIBLE
    }
}
