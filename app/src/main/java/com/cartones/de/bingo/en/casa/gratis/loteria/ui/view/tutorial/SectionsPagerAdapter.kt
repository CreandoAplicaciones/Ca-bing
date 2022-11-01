package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment =
        TutorialFragment.newInstance(position + 1)

    override fun getItemCount(): Int = 4
}