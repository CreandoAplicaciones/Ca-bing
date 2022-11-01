package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.splash

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.SHARED_NAME
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save.Prefs
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch


class SplashViewModel (): BaseViewModel() {

    sealed class Event {
        object GoToMain: Event()
        object GoToTutorial: Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences


    fun initFlow(context: Context) {
        sharedPref = context.getSharedPreferences(SHARED_NAME,0)
        checkIfIsFirstTime()
    }

    private fun checkIfIsFirstTime() {
        if (Prefs.getFirstDay(sharedPref)) {
            doEvent(Event.GoToMain)
        } else {
            doEvent(Event.GoToTutorial)
        }
    }

    //region output
    private fun doEvent(event: Event) {
        Handler(Looper.getMainLooper()).postDelayed({
            viewModelScope.launch {
                eventChannel.send(event)
            }
        },1500)
    }
    //endregion
}