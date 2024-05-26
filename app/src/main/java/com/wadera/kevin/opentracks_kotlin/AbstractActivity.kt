package com.wadera.kevin.opentracks_kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wadera.kevin.opentracks_kotlin.settings.PreferenceUtils

public abstract class AbstractActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (PreferenceUtils.shouldApplyOLEDTheme()) {
            setTheme(R.style.OpenTracksTheme)
        }

        super.onCreate(savedInstanceState)

//        // Set volume control stream for text to speech
//        setVolumeControlStream(TTSManager.AUDIO_STREAM);

        setContentView(getRootView())
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    abstract fun getRootView(): View
}