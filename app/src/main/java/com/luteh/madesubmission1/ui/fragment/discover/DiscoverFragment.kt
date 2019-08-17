package com.luteh.madesubmission1.ui.fragment.discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.ui.activity.home.HomeActivity
import com.luteh.madesubmission1.ui.activity.home.HomePagerAdapter
import com.luteh.madesubmission1.ui.fragment.discover.movies.DiscoverMovieFragment
import com.luteh.madesubmission1.ui.fragment.discover.tvshow.DiscoverTvShowFragment
import kotlinx.android.synthetic.main.home_content.*
import org.jetbrains.anko.support.v4.onPageChangeListener

/**
 * Created by Luthfan Maftuh on 7/3/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DiscoverFragment : BaseFragment() {

    private lateinit var pagerAdapter: HomePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupView()
    }

    private fun setupView() {
        if (!::pagerAdapter.isInitialized) {
            pagerAdapter = HomePagerAdapter(childFragmentManager)
            pagerAdapter.apply {
                addFragment(DiscoverMovieFragment(), getString(R.string.title_movie))
                addFragment(DiscoverTvShowFragment(), getString(R.string.title_tv_show))
            }
        }

        pager_main.adapter = pagerAdapter
        pager_main.onPageChangeListener {
            onPageSelected { position ->
                HomeActivity.currentDiscoverPagerPosition = position
            }
        }

        tab_main.setupWithViewPager(pager_main)
    }
}