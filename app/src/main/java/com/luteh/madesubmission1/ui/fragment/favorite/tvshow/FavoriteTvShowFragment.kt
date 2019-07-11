package com.luteh.madesubmission1.ui.fragment.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.TvShowData
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.fragment.favorite.tvshow.adapter.FavoriteTvShowAdapter
import com.luteh.madesubmission1.ui.fragment.favorite.tvshow.adapter.FavoriteTvShowItemListener
import kotlinx.android.synthetic.main.common_loading.*
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Luthfan Maftuh on 7/11/2019.
 * Email luthfanmaftuh@gmail.com
 */
class FavoriteTvShowFragment: BaseFragment(), FavoriteTvShowItemListener, FavoriteTvShowNavigator {

    private lateinit var viewModel: FavoriteTvShowViewModel

    private val tvShowAdapter = FavoriteTvShowAdapter(this)

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

        viewModel.loadAllTvShows()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FavoriteTvShowViewModel::class.java)
        viewModel.mNavigator = this

        viewModel.mIsLoading.observe(this, Observer {
            if (it) {
                pb_common_loading.visibility = View.VISIBLE
                rv_main.visibility = View.INVISIBLE
            } else {
                pb_common_loading.visibility = View.INVISIBLE
                rv_main.visibility = View.VISIBLE
            }
        })

        viewModel.tvShowDataList.observe(this, Observer {
            tvShowAdapter.setDataSource(it)
        })
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    override fun onItemClicked(data: TvShowData) {
        startActivity<DetailActivity>(AppConstant.KEY_BUNDLE_HOME_DATA to data)
    }
}