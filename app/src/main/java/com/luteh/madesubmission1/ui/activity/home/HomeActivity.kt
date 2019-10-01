package com.luteh.madesubmission1.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.ACTION_LOCALE_SETTINGS
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.ui.fragment.movies.MoviesFragment
import com.luteh.madesubmission1.ui.fragment.tvshow.TvShowFragment
import kotlinx.android.synthetic.main.home_activity.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        initActionBar()
        setupView()
    }

    private fun initActionBar() {
        title = getString(R.string.title_home)
    }

    private fun setupView() {
        val pagerAdapter = HomePagerAdapter(supportFragmentManager)
        pagerAdapter.apply {
            addFragment(MoviesFragment(), getString(R.string.title_movie))
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
