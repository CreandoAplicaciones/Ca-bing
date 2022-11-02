package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list75

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save.Prefs
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard75
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class CardsList75ViewModel: BaseViewModel() {

    sealed class Event {
        object SetUp: Event()
        object InitialInterstitial : Event()
        data class ShareApp(val ResInt: Int) : Event()
        data class ShowCards(val numberCards: List<NumberCard75>): Event()
        data class GoToCardsBingo75(val numberCard: NumberCard75): Event()
        data class ShowInterstitial(val isVisible: Boolean): Event()
    }

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences
    private var interstitial = false
    private var numberClick: Long = 0
    private var db = Firebase.firestore


    //region ViewModel Input
    fun initFlow(context: Context) {
        doAction(Event.SetUp)
        doAction(Event.ShowCards(Utils.numbers75()))
        doAction(Event.InitialInterstitial)
        sharedPref = context.getSharedPreferences(SHARED_NAME,0)
        getAdmobInterstitial()
        Prefs.getClick(sharedPref)
    }

    private fun getAdmobInterstitial() {
        viewModelScope.launch {
            val maximum = db.collection(ADMOB).document(INTERSTICIAL)
            maximum.get()
                .addOnSuccessListener { document ->
                    document?.let {
                        if(document.data?.get(SHOW_INTERSTICIAL) != null){
                            interstitial = document.data?.get(SHOW_INTERSTICIAL) as Boolean
                        }
                    }
                }
        }
    }

    private fun getNumberInterstitial() {
        viewModelScope.launch {
            val maximum = db.collection(ADMOB).document(INTERSTICIAL)
            maximum.get()
                .addOnSuccessListener { document ->
                    document?.let {
                        if(document.data?.get(NUMBER_INTERSTITIAL) != null){
                            numberClick = document.data?.get(NUMBER_INTERSTITIAL) as Long
                            Prefs.saveClick(sharedPref, numberClick)
                        }
                    }
                }
        }
    }

    private fun didOnClick() {
        if (numberClick <= 0) {
            doAction(Event.ShowInterstitial(interstitial))
            getNumberInterstitial()
        } else {
            numberClick -= 1
            Prefs.saveClick(sharedPref,numberClick-1)
        }
    }

    fun onExerciseClicked(numberCard75: NumberCard75) {
        didOnClick()
        doAction(Event.GoToCardsBingo75(numberCard75))
    }

    fun showedInterstitial() {
        doAction(Event.InitialInterstitial)
    }

    fun didOnClickButtonShare() {
        doAction(Event.ShareApp(R.string.main_share))
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