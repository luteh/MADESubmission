package com.luteh.madesubmission1.ui.activity.detail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.Constants
import com.luteh.madesubmission1.utils.FakeHomeDataFactory
import org.junit.Rule
import org.junit.Test

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class DetailActivityTest {

    private val homeData = FakeHomeDataFactory.getMovieDatas()[0]

    @get:Rule
    var activityRule: ActivityTestRule<DetailActivity> = object :
        ActivityTestRule<DetailActivity>(DetailActivity::class.java) {
        override fun getActivityIntent(): Intent {
            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext, DetailActivity::class.java)
            result.putExtra(Constants.KEY_BUNDLE_HOME_DATA, homeData)
            return result
        }
    }

    @Test
    fun loadHomeData() {
        homeData.let {
            onView(withId(R.id.tv_detail_title)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.title)))
            }

            onView(withId(R.id.tv_detail_overview)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.overview)))
            }

            onView(withId(R.id.tv_detail_release_date)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.releaseDate)))
            }

            onView(withId(R.id.tv_detail_language)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.language)))
            }

            onView(withId(R.id.tv_detail_runtime)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.runtime)))
            }

            onView(withId(R.id.tv_detail_genres)).apply {
                check(matches(isDisplayed()))
                check(matches(withText(it.genres)))
            }
        }
    }
}