package com.luteh.madesubmission1.ui.activity.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.data.model.api.movie.MovieData
import com.luteh.madesubmission1.data.model.api.tvshow.TvShowData
import com.luteh.madesubmission1.ui.MyViewModelFactory
import kotlinx.android.synthetic.main.detail_activity.*
import org.jetbrains.anko.longToast
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class DetailActivity : AppCompatActivity(), DetailNavigator, KodeinAware {

    override val kodein: Kodein by closestKodein()
    private val viewModelFactory: MyViewModelFactory by instance()
    private lateinit var viewModel: DetailViewModel

    private lateinit var bundleData: Any

    private lateinit var menu_like: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        onInit()
    }

    private fun onInit() {
        initViewModel()

        bundleData = intent.getParcelableExtra(AppConstant.KEY_BUNDLE_HOME_DATA)

        if (bundleData is MovieData) {
            setupView(bundleData as MovieData)
        } else {
            setupView(bundleData as TvShowData)
        }
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
        menu_like.setIcon(R.drawable.ic_favorite_red_24dp)
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
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_like -> {
                viewModel.saveDetailData(bundleData)
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
