package com.luteh.madesubmission1.ui.fragment.movies

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.luteh.madesubmission1.common.utils.EspressoIdlingResource
import com.luteh.madesubmission1.testing.SingleFragmentActivity
import com.luteh.madesubmission1.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Created by Luthfan Maftuh on 11/2/2019.
 * Email luthfanmaftuh@gmail.com
 */
open class MovieFragmentTest {
    @get:Rule
    val activityRule = ActivityTestRule<SingleFragmentActivity>(SingleFragmentActivity::class.java)
    private val moviesFragment = MovieFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadCourses() {
        onView(withId(com.luteh.madesubmission1.R.id.rv_main)).check(matches(isDisplayed()))
        onView(withId(com.luteh.madesubmission1.R.id.rv_main)).check(
            RecyclerViewItemCountAssertion(
                20
            )
        )
    }

    @Test
    fun toDetailActivityTest() {
        onView(withId(com.luteh.madesubmission1.R.id.rv_main)).apply {
            perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        }

        onView(withId(com.luteh.madesubmission1.R.id.tv_detail_title)).apply {
            check(matches(isDisplayed()))
        }
    }
}