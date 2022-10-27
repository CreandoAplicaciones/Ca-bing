package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list.CardsListViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CardsBingoViewModel : BaseViewModel() {

    sealed class Event {
        data class ShowCards(val numberCards: List<NumberCard>): Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    //region ViewModel Input
    fun initFlow() {
        doAction(Event.ShowCards(Utils.numbers()))
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