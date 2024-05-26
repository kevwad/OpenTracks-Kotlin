package com.wadera.kevin.opentracks_kotlin.introduction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wadera.kevin.opentracks_kotlin.AbstractActivity
import com.wadera.kevin.opentracks_kotlin.R
import com.wadera.kevin.opentracks_kotlin.databinding.ActivityIntroductionBinding

class IntroductionActivity : AbstractActivity() {

    private lateinit var viewBinding: ActivityIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)
    }

    override fun getRootView(): View {
        viewBinding = ActivityIntroductionBinding.inflate(layoutInflater)
        return viewBinding.root
    }
}