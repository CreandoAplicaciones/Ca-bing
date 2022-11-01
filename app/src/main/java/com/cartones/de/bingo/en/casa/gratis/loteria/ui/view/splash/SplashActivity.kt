package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.splash


import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ActivitySplashBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseActivity
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.main.MainActivity
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.splash.SplashViewModel.Event.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial.TutorialActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.init(viewModel)
        viewModel.initFlow(this)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.eventsFlow.observe(this, ::updateUi)
    }

    private fun updateUi(model: SplashViewModel.Event) {
        when (model) {
            is GoToMain -> startActivity(MainActivity.newIntent(this))
            is GoToTutorial -> startActivity(TutorialActivity.newIntent(this))
        }
        finish()
    }
}