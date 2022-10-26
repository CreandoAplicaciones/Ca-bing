package com.cartones.de.bingo.en.casa.gratis.loteria.ui.base

sealed class BaseEvent {
    data class ShowMessage(val message: Int): BaseEvent()
    data class ShowLoading(val visibility: Boolean): BaseEvent()
}