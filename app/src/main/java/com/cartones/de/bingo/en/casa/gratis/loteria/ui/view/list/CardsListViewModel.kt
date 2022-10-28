package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CardsListViewModel: BaseViewModel() {

    sealed class Event {
        data class ShowCards(val numberCards: List<NumberCard>): Event()
        object GoToCardsBingo: Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences
    private var listNumber: MutableList<NumberCard> = mutableListOf()

    //region ViewModel Input
    fun initFlow(activity: Activity) {
        doAction(Event.ShowCards(Utils.numbers()))
        sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
    }

    fun onExerciseClicked(numberCard: NumberCard) {
        listNumber.add(numberCard)
        Utils.saveLists(sharedPref, listNumber)
        doAction(Event.GoToCardsBingo)
    }



    //endregion

    //region ViewModel Output
    private fun doAction(event: Event) {
        viewModelScope.launch {
            eventChannel.send(event)
        }
    }
    //endregion
}