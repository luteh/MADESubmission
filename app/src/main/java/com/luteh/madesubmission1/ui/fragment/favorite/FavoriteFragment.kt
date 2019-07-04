package com.luteh.madesubmission1.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.ui.activity.home.HomePagerAdapter
import com.luteh.madesubmission1.ui.fragment.movies.MovieFragment
import com.luteh.madesubmission1.ui.fragment.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.home_content.*

/**
 * Created by Luthfan Maftuh on 7/3/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteFragment : BaseFragment() {

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
                addFragment(MovieFragment(), getString(R.string.title_movie))
                addFragment(TvShowFragment(), getString(R.string.title_tv_show))
            }
        }

        pager_main.adapter = pagerAdapter

        tab_main.setupWithViewPager(pager_main)
    }
}