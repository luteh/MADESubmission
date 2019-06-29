package com.luteh.madesubmission1.ui.activity.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Luthfan Maftuh on 6/25/2019.
 * Email luthfanmaftuh@gmail.com
 */
class HomePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val mFragmentList: MutableList<Fragment> = mutableListOf()
    private val mFragmentTitleList: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment = mFragmentList[position]

    override fun getCount(): Int = mFragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitleList[position]

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}