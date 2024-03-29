package com.luteh.madesubmission1.ui.activity.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseActivity
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.db.MovieData
import com.luteh.madesubmission1.data.model.db.TvShowData
import kotlinx.android.synthetic.main.detail_activity.*
import org.jetbrains.anko.longToast

class DetailActivity : BaseActivity(), DetailNavigator {

    private lateinit var viewModel: DetailViewModel

    private lateinit var bundleData: Any
    private var isDataLiked = false

    private lateinit var menu_like: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onInit()
    }

    private fun onInit() {
        bundleData = intent.getParcelableExtra(AppConstant.KEY_BUNDLE_HOME_DATA)

        initViewModel()

        if (bundleData is MovieData) {
            setupView(bundleData as MovieData)
        } else {
            setupView(bundleData as TvShowData)
        }

        viewModel.getDetailData(bundleData)
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        viewModel.mNavigator = this
    }

    private fun setupView(homeData: MovieData) {
        homeData.let {
            tv_detail_title.text = it.title
            tv_detail_release_date.text = it.releaseDate
            tv_detail_language.text = it.originalLanguage
            tv_detail_popularity.text = it.popularity.toString()
            tv_detail_user_score.text = it.voteAverage.toString()

            tv_detail_overview.text = if (!it.overview.isNullOrEmpty())
                it.overview
            else
                resources.getString(R.string.label_message_no_overview)


            Glide.with(this)
                .load(AppConstant.BASE_URL_IMAGE + it.posterPath)
                .dontAnimate()
                .into(iv_detail)
        }
    }

    private fun setupView(homeData: TvShowData) {
        homeData.let {
            tv_detail_title.text = it.name
            tv_detail_release_date.text = it.firstAirDate
            tv_detail_language.text = it.originalLanguage
            tv_detail_popularity.text = it.popularity.toString()
            tv_detail_user_score.text = it.voteAverage.toString()

            tv_detail_overview.text = if (!it.overview.isNullOrEmpty())
                it.overview
            else
                resources.getString(R.string.label_message_no_overview)

            Glide.with(this)
                .load(AppConstant.BASE_URL_IMAGE + it.posterPath)
                .dontAnimate()
                .into(iv_detail)
        }
    }

    override fun onSuccessSaveDetailData() {
        longToast(getString(R.string.label_message_save_detail_success))

    }

    override fun onErrorSaveDetailData() {
        longToast(getString(R.string.label_message_save_detail_error))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menu_like = menu.findItem(R.id.menu_like)

        viewModel.isDataSaved.observe(this, Observer {
            if (it)
                menu_like.setIcon(R.drawable.ic_favorite_red_24dp)
            else
                menu_like.setIcon(R.drawable.ic_favorite_border_24dp)

            isDataLiked = it
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_like -> {
                if (!isDataLiked) {
                    viewModel.saveDetailData(bundleData)
                } else {
                    viewModel.deleteDetailData(bundleData)
                }
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
