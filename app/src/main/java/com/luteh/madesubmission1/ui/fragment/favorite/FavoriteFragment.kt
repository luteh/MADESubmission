package com.luteh.madesubmission1.ui.fragment.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.ui.activity.home.HomePagerAdapter
import com.luteh.madesubmission1.ui.fragment.favorite.movie.FavoriteMovieFragment
import com.luteh.madesubmission1.ui.fragment.favorite.tvshow.FavoriteTvShowFragment
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
                addFragment(FavoriteMovieFragment(), getString(R.string.title_movie))
                addFragment(FavoriteTvShowFragment(), getString(R.string.title_tv_show))
            }
        }

        pager_main.adapter = pagerAdapter

        tab_main.setupWithViewPager(pager_main)
    }
}