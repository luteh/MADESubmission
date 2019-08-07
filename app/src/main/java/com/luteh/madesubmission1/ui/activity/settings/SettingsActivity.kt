package com.luteh.madesubmission1.ui.activity.settings

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.luteh.madesubmission1.R
import com.luteh.madesubmission1.common.base.BaseActivity

private lateinit var viewModel: SettingsViewModel

class SettingsActivity : BaseActivity(), SettingsNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        onInit()
    }

    private fun onInit() {
        initViewModel()
        setupView()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SettingsViewModel::class.java)
        viewModel.mNavigator = this
    }

    private fun setupView() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {

        private val TAG = "SettingsFragment"

        private lateinit var releaseReminderPref: SwitchPreference
        private lateinit var dailyReminderPref: SwitchPreference

        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            addPreferencesFromResource(R.xml.preferences)

            setupView()
        }

        private fun setupView() {
            releaseReminderPref =
                findPreference(getString(R.string.key_release_reminder)) as SwitchPreference
            dailyReminderPref =
                findPreference(getString(R.string.key_daily_reminder)) as SwitchPreference

            releaseReminderPref.setOnPreferenceChangeListener { preference, newValue ->
                if (!releaseReminderPref.isChecked) {
                    Log.d(TAG, "setupView: Release checked")
                }

                true
            }

            dailyReminderPref.setOnPreferenceChangeListener { preference, newValue ->
                if (!dailyReminderPref.isChecked) {
                    Log.d(TAG, "setupView: Daily Checked")
                    viewModel.startDailyReminder(this)
                } else
                    viewModel.cancelDailyReminder()

                true
            }
        }
    }
}