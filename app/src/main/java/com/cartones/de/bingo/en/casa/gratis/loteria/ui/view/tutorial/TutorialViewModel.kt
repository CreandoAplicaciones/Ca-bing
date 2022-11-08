package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial

import android.view.View
import androidx.lifecycle.*
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel

class TutorialViewModel: BaseViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<Int> = Transformations.map(_index) {
        when(it){
            1 -> R.string.tutorial_if_you_want_more_cards
            2 -> R.string.tutorial_if_you_want_changer_speed
            3 -> R.string.tutorial_if_you_want_to_start
            4 -> R.string.tutorial_if_you_want_new_play
            5 -> R.string.tutorial_check_number
            else -> it
        }
    }


    val image: LiveData<Int> = Transformations.map(_index) {
        when(it){
            1 -> R.drawable.tutorial_more_cards
            2 -> R.drawable.tutorial_speed
            3 -> R.drawable.tutorial_play
            4 -> R.drawable.tutorial_new_play
            5 -> R.drawable.tutorial_chaeck
            else -> R.drawable.tutorial_more_cards
        }
    }

    val btn: LiveData<Int> = Transformations.map(_index) {
        when(it){
            1->  View.INVISIBLE
            2-> View.INVISIBLE
            3-> View.INVISIBLE
            4-> View.INVISIBLE
            5-> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun didClickOnClickBegin() {
    }
}