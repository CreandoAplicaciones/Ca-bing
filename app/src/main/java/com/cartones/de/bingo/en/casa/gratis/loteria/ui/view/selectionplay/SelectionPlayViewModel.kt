package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.selectionplay

import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SelectionPlayViewModel: BaseViewModel() {

    sealed class Event {
        object SetUp: Event()
        object GoToTutorial: Event()
        object GoTo90: Event()
        object GoTo75: Event()

    }
    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()

    //region ViewModel Input
    fun initFlow() {
        doAction(Event.SetUp)
    }

    fun didOnClickBtn90() {
      doAction(Event.GoTo90)
    }
    fun didOnClickBtn75() {
        doAction(Event.GoTo75)
    }
    fun didOnClickBtnTutorial() {
        doAction(Event.GoToTutorial)
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