package com.luteh.madesubmission1.ui.activity.detail

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.luteh.madesubmission1.common.Constants
import com.luteh.madesubmission1.model.HomeData
import com.luteh.madesubmission1.R
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val homeData: HomeData = intent.getParcelableExtra(Constants.KEY_BUNDLE_HOME_DATA)

        setupView(homeData)
    }

    private fun setupView(homeData: HomeData) {
        homeData.let {
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
