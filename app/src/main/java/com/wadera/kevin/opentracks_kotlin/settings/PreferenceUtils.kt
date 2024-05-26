package com.wadera.kevin.opentracks_kotlin.settings

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.content.res.Resources
import androidx.preference.PreferenceManager
import com.wadera.kevin.opentracks_kotlin.R

public class PreferenceUtils {
    private val TAG: String = this::class.simpleName ?: "PreferenceUtils"



    companion object {
        private lateinit var sharedPreferences: SharedPreferences

        private lateinit var resources: Resources

        private const val PREFERENCES_VERSION: Int = 2

        fun initPreferences(context: Context) {
            PreferenceUtils.resources = context.resources
            PreferenceUtils.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            PreferencesOpenHelper.newInstance(PREFERENCES_VERSION)
        }

        public fun registerOnSharedPreferenceChangeListener(changeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(changeListener)
            changeListener.onSharedPreferenceChanged(sharedPreferences, null)
        }

        public fun registerOnSharedPreferenceChangeListenerSilent(changeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(changeListener)
        }

        public fun unregisterOnSharedPreferenceChangeListener(changeListener: SharedPreferences.OnSharedPreferenceChangeListener) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(changeListener)
        }

        public fun getKey(keyId: Int): String {
            return resources.getString(keyId)
        }

        public fun getDefaultActivityTypeLocalized(): String {
            return getString(R.string.default_activity_key, "UNKNOWN")
        }

        public fun setDefaultActivityLocalized(newDefaultActivity: String) {
            setString(R.string.default_activity_key, newDefaultActivity)
        }

        public fun getString(keyId: Int, default: String): String {
            return sharedPreferences.getString(getKey(keyId), default) ?: default
        }

        public fun setString(keyId: Int, valueId: String) {
            val editor: Editor = sharedPreferences.edit()
            editor.putString(getKey(keyId), valueId)
            editor.apply()
        }

        public fun setString(keyId: Int, valueId: Int) {
            setString(keyId, resources.getString(valueId))
        }

        public fun getUiMode(): String {
            val defaultValue: String = getKey(R.string.night_mode_default)
            return getString(R.string.night_mode_key, defaultValue)
        }

        public fun shouldApplyOLEDTheme(): Boolean {
            return resources.getString(R.string.night_mode_night_oled_value) == getUiMode()
        }
    }
}