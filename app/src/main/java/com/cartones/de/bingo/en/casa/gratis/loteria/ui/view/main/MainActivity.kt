package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.main

import com.cartones.de.bingo.en.casa.gratis.loteria.R
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ActivityMainBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseActivity
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.GOOGLE_PLAY
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.main.MainViewModel.Event.*
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private val adRequest = AdRequest.Builder().build()

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initFlow()
        viewModel.eventsFlow.observe(this, ::updateUi)

    }

    private fun updateUi(model: MainViewModel.Event) {
        when (model) {
            is SetUp -> {
                MobileAds.initialize(this) {}
                binding.adViewSup.loadAd(adRequest)
                binding.adViewInf.loadAd(adRequest)

            }
            is ShowBanner -> {
                binding.adViewInf.isVisible = model.isVisible
                binding.adViewSup.isVisible = model.isVisible
            }

        }
    }


}
