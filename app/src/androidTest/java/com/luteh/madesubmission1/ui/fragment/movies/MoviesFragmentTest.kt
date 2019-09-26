package com.luteh.madesubmission1.ui.fragment.movies

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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
open class MoviesFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private val moviesFragment = MoviesFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
    }

    @Test
    fun loadCourses() {
        onView(withId(R.id.rv_main)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_main)).check(RecyclerViewItemCountAssertion(20))
    }
}