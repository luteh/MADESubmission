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
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luteh.madesubmission1.common.Commons
import com.luteh.madesubmission1.common.Commons.currentLanguage
import com.luteh.madesubmission1.common.base.BaseActivity
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_ENGLISH
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_INDONESIAN
import com.luteh.madesubmission1.ui.fragment.discover.DiscoverFragment
import com.luteh.madesubmission1.ui.fragment.favorite.FavoriteFragment
import java.util.*


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

//        setupView()
        changeFragment(R.id.layout_home_container, DiscoverFragment(), R.string.title_discover)
        nav_home.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val currentLanguageCode = Locale.getDefault().toString()
        Commons.currentLanguage.value =
            if (currentLanguageCode.contains("en")) LANGUAGE_CODE_ENGLISH else LANGUAGE_CODE_INDONESIAN
    }

    /*private fun setupView() {
        val pagerAdapter = HomePagerAdapter(supportFragmentManager)
        pagerAdapter.apply {
            addFragment(MovieFragment(), getString(R.string.title_movie))
            addFragment(TvShowFragment(), getString(R.string.title_tv_show))
        }

        pager_main.adapter = pagerAdapter

        tab_main.setupWithViewPager(pager_main)
    }*/

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_discover -> {
                    changeFragment(
                        R.id.layout_home_container,
                        DiscoverFragment(),
                        R.string.title_discover
                    )
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_favorite -> {
                    changeFragment(
                        R.id.layout_home_container,
                        FavoriteFragment(),
                        R.string.title_favorite
                    )
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
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
