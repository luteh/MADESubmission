package com.luteh.madesubmission1.ui.fragment.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Constants
import com.luteh.madesubmission1.model.HomeData
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.adapter.MainAdapter
import com.luteh.madesubmission1.ui.adapter.OnHomeItemClickListener
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Luthfan Maftuh on 6/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowFragment : Fragment(), OnHomeItemClickListener {

    private lateinit var tvShowViewModel: TvShowViewModel

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
        tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        movieAdapter.apply {
            setDataSource(tvShowViewModel.getTvShowDatas(context))
            setItemClickListener(this@TvShowFragment)
        }
    }

    override fun onItemClicked(data: HomeData) {
        startActivity<DetailActivity>(Constants.KEY_BUNDLE_HOME_DATA to data)
    }
}