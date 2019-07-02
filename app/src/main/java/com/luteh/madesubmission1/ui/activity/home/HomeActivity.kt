package com.luteh.madesubmission1.ui.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.luteh.madesubmission1.*
import com.luteh.madesubmission1.ui.fragment.movies.MovieFragment
import com.luteh.madesubmission1.ui.fragment.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.home_activity.*
import android.provider.Settings.ACTION_LOCALE_SETTINGS
import android.content.Intent
import android.util.Log
import com.luteh.madesubmission1.common.Commons
import com.luteh.madesubmission1.common.Commons.currentLanguage
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_ENGLISH
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_INDONESIAN
import java.util.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        title = "Home"

        setupView()

        val currentLanguageCode = Locale.getDefault().toString()
        Commons.currentLanguage.value =
            if (currentLanguageCode.contains("en")) LANGUAGE_CODE_ENGLISH else LANGUAGE_CODE_INDONESIAN
    }

    private fun setupView() {
        val pagerAdapter = HomePagerAdapter(supportFragmentManager)
        pagerAdapter.apply {
            addFragment(MovieFragment(), getString(R.string.title_movie))
            addFragment(TvShowFragment(), getString(R.string.title_tv_show))
        }

        pager_main.adapter = pagerAdapter

        tab_main.setupWithViewPager(pager_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_setting -> {
                val intent = Intent(ACTION_LOCALE_SETTINGS)
                startActivity(intent)
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
