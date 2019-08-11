package com.luteh.madesubmission1

import android.app.Application
import com.luteh.madesubmission1.data.MyRepository
import com.luteh.madesubmission1.data.MyRepositoryImpl
import com.luteh.madesubmission1.data.local.db.MyDatabase
import com.luteh.madesubmission1.data.local.db.MyDbHelper
import com.luteh.madesubmission1.data.local.db.MyDbHelperImpl
import com.luteh.madesubmission1.data.local.prefs.PreferencesHelper
import com.luteh.madesubmission1.data.remote.ApiServiceInterface
import com.luteh.madesubmission1.ui.MyViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Luthfan Maftuh on 6/29/2019.
 * Email luthfanmaftuh@gmail.com
 */
class MyApp : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MyApp))

        // Provide instance
        bind() from singleton { ApiServiceInterface() }
        bind() from singleton { MyDatabase(instance()) }
        bind() from singleton { PreferencesHelper(instance()) }

        bind<MyDbHelper>() with singleton {
            MyDbHelperImpl(
                instance()
            )
        }
        bind<MyRepository>() with singleton { MyRepositoryImpl(instance(), instance(), instance()) }

        // Inject View Model Factory
        bind() from provider { MyViewModelFactory(instance()) }
    }
}