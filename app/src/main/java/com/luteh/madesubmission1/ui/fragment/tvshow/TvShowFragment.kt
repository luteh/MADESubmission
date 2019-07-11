package com.luteh.madesubmission1.ui.fragment.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Commons
import com.luteh.madesubmission1.common.base.BaseFragment
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.TvShowData
import com.luteh.madesubmission1.ui.activity.detail.DetailActivity
import com.luteh.madesubmission1.ui.fragment.tvshow.adapter.OnTvShowItemClickListener
import com.luteh.madesubmission1.ui.fragment.tvshow.adapter.TvShowAdapter
import kotlinx.android.synthetic.main.common_loading.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.no_connection.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Luthfan Maftuh on 6/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowFragment : BaseFragment(), OnTvShowItemClickListener, TvShowNavigator {

    private val TAG = "TvShowFragment"

    private lateinit var viewModel: TvShowViewModel

    private val tvShowAdapter = TvShowAdapter()

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

        viewModel.getTvShowData(Commons.currentLanguage.value ?: AppConstant.LANGUAGE_CODE_ENGLISH)

        Commons.currentLanguage.observe(this, androidx.lifecycle.Observer {
            Log.d(TAG, "onActivityCreated: $it")
            viewModel.getTvShowData(it)
        })

        btn_no_connection_retry.setOnClickListener {
            layout_no_connection_container.visibility = View.INVISIBLE
            viewModel.getTvShowData(Commons.currentLanguage.value ?: AppConstant.LANGUAGE_CODE_ENGLISH)
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TvShowViewModel::class.java)
        viewModel.mNavigator = this

        viewModel.mIsLoading.observe(this, androidx.lifecycle.Observer {
            if (it) {
                pb_common_loading.visibility = View.VISIBLE
                rv_main.visibility = View.INVISIBLE
            } else {
                pb_common_loading.visibility = View.INVISIBLE
                rv_main.visibility = View.VISIBLE
            }
        })

        viewModel.tvShowDatas.observe(this, androidx.lifecycle.Observer {
            tvShowAdapter.setDataSource(it)
        })
    }

    private fun setupRecyclerView() {
        rv_main.apply {
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }

        tvShowAdapter.setItemClickListener(this@TvShowFragment)

    }

    override fun onItemClicked(data: TvShowData) {
        startActivity<DetailActivity>(AppConstant.KEY_BUNDLE_HOME_DATA to data)
    }

    override fun onErrorGetTvShowData() {
        layout_no_connection_container.visibility = View.VISIBLE
        rv_main.visibility = View.INVISIBLE
    }
}