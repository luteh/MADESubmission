package com.luteh.madesubmission1.ui.activity.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Constants
import com.luteh.madesubmission1.model.HomeData
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailViewModel: DetailViewModel

    private lateinit var homeData: HomeData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        homeData = intent.getParcelableExtra(Constants.KEY_BUNDLE_HOME_DATA)

        initActionBar()
        initViewModel()
        setupView()
    }

    private fun initActionBar() {
        title = getString(R.string.title_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initViewModel() {
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        detailViewModel.homeData = homeData
    }

    private fun setupView() {
        detailViewModel.homeData?.let {
            iv_detail.setImageResource(it.imageResId)
            tv_detail_title.text = it.title
            tv_detail_overview.text = it.overview
            tv_detail_release_date.text = it.releaseDate
            tv_detail_language.text = it.language
            tv_detail_runtime.text = it.runtime
            tv_detail_genres.text = it.genres
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
