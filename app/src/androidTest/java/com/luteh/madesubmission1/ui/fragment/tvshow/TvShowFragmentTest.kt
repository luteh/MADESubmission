package com.luteh.madesubmission1.ui.fragment.tvshow

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.testing.SingleFragmentActivity
import com.luteh.madesubmission1.utils.RecyclerViewItemCountAssertion
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Created by Luthfan Maftuh on 9/26/2019.
 * Email luthfanmaftuh@gmail.com
 */
class TvShowFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private val tvShowFragment = TvShowFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(tvShowFragment)
    }

    @Test
    fun loadCourses() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_main))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_main)).check(RecyclerViewItemCountAssertion(20))
    }
}