package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

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

class CardsBingoViewModel: BaseViewModel() {

    sealed class Event {
        data class ShowCards(val numberCards: List<NumberCard>): Event()
    }
    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences


    //region ViewModel Input
    fun initFlow(activity: Activity) {
        sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        doAction(Event.ShowCards(Utils.getList(sharedPref)))
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