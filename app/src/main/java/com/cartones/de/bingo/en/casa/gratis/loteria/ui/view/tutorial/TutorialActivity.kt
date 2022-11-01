package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ActivityTutorialBinding
import com.google.android.material.tabs.TabLayoutMediator


class TutorialActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, TutorialActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
    }
    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { _, _ -> }.attach()
    }
}