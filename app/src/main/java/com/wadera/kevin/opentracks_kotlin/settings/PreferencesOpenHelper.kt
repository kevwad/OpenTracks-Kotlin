package com.wadera.kevin.opentracks_kotlin.settings

class PreferencesOpenHelper {

    companion object {
        fun newInstance(version: Int): PreferencesOpenHelper {
            return PreferencesOpenHelper(version)
        }
    }

    private val version: Int

    private constructor(version: Int) {
        this.version = version
    }

}