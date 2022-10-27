package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list

import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CardsListViewModel : BaseViewModel() {

    sealed class Event {
        data class ShowCards(val numberCards: List<NumberCard>): Event()
        data class GoToCardsBingo(val numberCards: NumberCard): Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    //region ViewModel Input
    fun initFlow() {
        doAction(Event.ShowCards(Utils.numbers()))
    }


    fun onExerciseClicked(numberCard: NumberCard) {
        doAction(Event.GoToCardsBingo(numberCard))
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