package com.luteh.madesubmission1.common.base

import androidx.fragment.app.Fragment
import com.luteh.madesubmission1.ui.MyViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
abstract class BaseFragment : Fragment(), KodeinAware {

    override val kodein: Kodein by closestKodein()
    val viewModelFactory: MyViewModelFactory by instance()

    val baseActivity: BaseActivity
        get() = activity as BaseActivity
}