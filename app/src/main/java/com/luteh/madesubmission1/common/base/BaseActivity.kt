package com.luteh.madesubmission1.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by Luthfan Maftuh on 7/3/2019.
 * Email luthfanmaftuh@gmail.com
 */
abstract class BaseActivity : AppCompatActivity(){

    fun changeFragment(
        containerViewId: Int,
        fragment: Fragment,
        tagFragmentName: Int,
        bundle: Bundle? = null
    ) {

        val fragmentName = getString(tagFragmentName)

        supportActionBar?.title = fragmentName

        val mFragmentManager = supportFragmentManager
        val fragmentTransaction = mFragmentManager.beginTransaction()

        val currentFragment = mFragmentManager.primaryNavigationFragment
        if (currentFragment != null) {
            fragmentTransaction.detach(currentFragment)
        }

        var fragmentTemp = mFragmentManager.findFragmentByTag(fragmentName)
        if (fragmentTemp == null) {
            fragmentTemp = fragment
            fragmentTransaction.add(containerViewId, fragmentTemp, fragmentName)
        } else {
            fragmentTransaction.attach(fragmentTemp)
        }

        fragmentTemp.arguments = bundle

        fragmentTransaction.apply {
            setPrimaryNavigationFragment(fragmentTemp)
            setReorderingAllowed(true)
            commitNowAllowingStateLoss()
        }
    }
}