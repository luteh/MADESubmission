package com.luteh.madesubmission1.ui.fragment.movies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.HomeDataFactory
import com.luteh.madesubmission1.data.model.HomeData
import com.luteh.madesubmission1.ui.MyViewModelFactory
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.adapter.MainAdapter
import com.luteh.madesubmission1.ui.adapter.OnHomeItemClickListener
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.support.v4.startActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

/**
 * A simple [Fragment] subclass.
 *
 */
class MoviesFragment : BaseFragment(), OnHomeItemClickListener, MovieNavigator {

    private lateinit var viewModel: MovieViewModel

    private val movieAdapter = MainAdapter()

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
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MovieViewModel::class.java)
        viewModel.mNavigator = this
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        movieAdapter.apply {
            setDataSource(HomeDataFactory.getMovieDatas(context!!))
            setItemClickListener(this@MoviesFragment)
        }
    }

    override fun onItemClicked(data: HomeData) {
        startActivity<DetailActivity>(AppConstant.KEY_BUNDLE_HOME_DATA to data)
    }
}
