package com.luteh.madesubmission1.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.ACTION_LOCALE_SETTINGS
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Commons
import com.luteh.madesubmission1.common.base.BaseActivity
import com.luteh.madesubmission1.common.constant.AppConstant
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_ENGLISH
import com.luteh.madesubmission1.common.constant.AppConstant.LANGUAGE_CODE_INDONESIAN
import com.luteh.madesubmission1.ui.activity.settings.SettingsActivity
import com.luteh.madesubmission1.ui.fragment.discover.DiscoverFragment
import com.luteh.madesubmission1.ui.fragment.favorite.FavoriteFragment
import kotlinx.android.synthetic.main.home_activity.*
import org.jetbrains.anko.startActivity
import java.util.*


class HomeActivity : BaseActivity() {

    private var oldLanguage = Locale.getDefault().toString()

    companion object {
        var currentScreen = AppConstant.MOVIE_SCREEN
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setSupportActionBar(toolbar_home)

        nav_home.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        nav_home.selectedItemId = R.id.menu_discover

        setupSearchView()

        Commons.currentLanguage.value =
            if (oldLanguage.contains("en")) LANGUAGE_CODE_ENGLISH else LANGUAGE_CODE_INDONESIAN
    }

    private fun setupSearchView() {
        search_home.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (currentScreen == AppConstant.MOVIE_SCREEN) {

                } else {

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_discover -> {
                    changeFragment(
                        R.id.layout_home_container,
                        DiscoverFragment(),
                        R.string.title_discover
                    )
                    search_home.visibility = View.VISIBLE
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu_favorite -> {
                    changeFragment(
                        R.id.layout_home_container,
                        FavoriteFragment(),
                        R.string.title_favorite
                    )
                    search_home.visibility = View.GONE
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
                startActivity<SettingsActivity>()
            }
            R.id.menu_change_language -> {
                val intent = Intent(ACTION_LOCALE_SETTINGS)
                startActivity(intent)
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        if (Commons.currentLanguage.value != oldLanguage) {
            nav_home.selectedItemId = R.id.menu_discover
            oldLanguage = Commons.currentLanguage.value!!
        }
    }
}
