package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards75

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.media.MediaPlayer
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
import java.util.*
import kotlin.concurrent.schedule



class CardsBingo75ViewModel: BaseViewModel() {

    sealed class Event {
        object SetUp: Event()
        object GoToBack: Event()
        object ShowDialogRate: Event()
        data class ShowDialogCheck(val listNumbersComeOut: List<Int>): Event()
        data class ShowCards(val numberCards: List<NumberCard75>): Event()
        data class ShowNumber1(val number: String): Event()
        data class ShowNumber2(val number: String): Event()
        data class ShowNumber3(val number: String): Event()
        data class ShowLoading(val isVisibility: Boolean): Event()
        data class ShowPlayButton(val isVisibility: Boolean): Event()
        data class ShowPauseButton(val isVisibility: Boolean): Event()
        data class ChangeSpeedNumber(val speedNumber: String): Event()
        data class ShowToast(val resInt: Int): Event()
        data class ShowDialog(val title: Int, val message: Int, val firstOption: Int, val secondOption: Int): Event()
    }
    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences
    private lateinit var sharedPref2: SharedPreferences
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    private var listNumbersRandom = listOf<Int>()
    private var numberOfTheList = 0
    private var ifContinue = true
    private var clickPlay = false
    private var speed = 3000L
    private var speedNumber = 3
    private lateinit var mediaPlayer: MediaPlayer
    private var listNumber: MutableList<NumberCard75> = mutableListOf()
    private var listNumberComeOut: MutableList<Int> = mutableListOf()
    private var numberRate = 8L
    private var dialogRate = false
    private var time = 0
    private var db = Firebase.firestore



    //region ViewModel Input
    fun initFlow(activity: Activity, context: Context, numberCard75: NumberCard75) {
        this.context = context
        sharedPref = activity.getPreferences(MODE_PRIVATE)
        sharedPref2 = context.getSharedPreferences(SHARED_NAME,0)
        listNumber = Prefs.getList75(sharedPref).toMutableList()
        listNumber.add(numberCard75)
        doAction(Event.ShowCards(listNumber))
        Prefs.saveLists75(sharedPref, mutableListOf())
        getListNumberRandom()
        getRateIsTrue()
        numberRate = Prefs.getClickRate(sharedPref2)
        time = Prefs.getTime(sharedPref2)

    }

    private fun getRateIsTrue() {
        viewModelScope.launch {
            val maximum = db.collection(ADMOB).document(RATE)
            maximum.get()
                .addOnSuccessListener { document ->
                    document?.let {
                        if(document.data?.get(SHOW_DIALOG_RATE) != null){
                            dialogRate = document.data?.get(SHOW_DIALOG_RATE) as Boolean
                        }
                    }
                }
        }
    }

    private fun getListNumberRandom() {
        numberOfTheList = 0
        doAction(Event.ShowLoading(true))
        listNumbersRandom = Utils.getNumberRandom75()
        Prefs.saveFirstNumberList(sharedPref, listNumbersRandom[0])
        checkIfOtherList()
    }
    private fun checkIfOtherList() {
        if (listNumbersRandom[0] == Prefs.getFirstNumberList(sharedPref)) {
            listNumbersRandom = Utils.getNumberRandom()
            doAction(Event.ShowLoading(false))
            doAction(Event.SetUp)
        } else {
            bringAnotherRandomList()
        }
    }
    private fun bringAnotherRandomList() {
        listNumbersRandom = Utils.getNumberRandom()
        checkIfOtherList()
    }

    fun didOnClickPlay() {
        if (numberOfTheList == 0) {
            playAudio(R.raw.good_luck)
        } else {
            playAudio(R.raw.continue_game)
        }
        clickPlay = true
        playNumber()
        doAction(Event.ShowPauseButton(true))
        doAction(Event.ShowPlayButton(false))
    }

    fun didOnClickPause() {
        playAudio(R.raw.paused_game)
        pauseAudio()
    }

    private fun playNumber() {
        Timer().schedule(speed) {
            if (clickPlay) {
                playAudio(Utils.checkAudioLetter(listNumbersRandom[numberOfTheList]))
                Timer().schedule(500L) {
                playAudio(Utils.checkAudio(listNumbersRandom[numberOfTheList]))
                listNumberComeOut.add(listNumbersRandom[numberOfTheList])
                doAction(Event.ShowNumber1(listNumbersRandom[numberOfTheList].toString()))
                if (numberOfTheList > 0) {
                    doAction(Event.ShowNumber2(listNumbersRandom[numberOfTheList - 1].toString()))
                }
                if (numberOfTheList > 1) {
                    doAction(Event.ShowNumber3(listNumbersRandom[numberOfTheList - 2].toString()))
                }
                checkIfContinueCounting()
                }
            }
        }
    }
    private fun checkIfContinueCounting() {
        if (ifContinue && numberOfTheList < 90) {
            numberOfTheList += 1
            playNumber()
        }
    }

    fun didOnClickMore() {
        if (speedNumber < 6){
            speedNumber += 1
            speed = Utils.speed(speedNumber)
            doAction(Event.ChangeSpeedNumber(speedNumber.toString()))
        }
    }

    fun didOnClickLess() {
        if (speedNumber > 0){
            speedNumber -= 1
            speed = Utils.speed(speedNumber)
            doAction(Event.ChangeSpeedNumber(speedNumber.toString()))
        }
    }

    fun didOnclickRandom() {
        doAction(Event.ShowDialog(R.string.bingo, R.string.do_you_want_play_again, R.string.accept, R.string.cancel))
        pauseAudio()
    }

    private fun playAudio (raw: Int) {
        mediaPlayer = MediaPlayer.create(context, raw)
        mediaPlayer.start()
    }
    private fun pauseAudio() {
        clickPlay = false
        doAction(Event.ShowPauseButton(false))
        doAction(Event.ShowPlayButton(true))
    }

    fun didOnClickCardsMore() {
        checkHawManyCartonsThereAre()
        pauseAudio()
    }
    private fun checkHawManyCartonsThereAre() {
        if (listNumber.size <= 5) {
            doAction(Event.ShowDialog(R.string.bingo, R.string.do_you_want_more_cards, R.string.yes, R.string.no))
        } else {
            doAction(Event.ShowToast(R.string.cards_bingo_you_cant_have_more_6))
        }
    }

    private fun saveListNumber() {
        Prefs.saveLists75(sharedPref, listNumber)
        goToBack()
    }

    private fun goToBack() {
        doAction(Event.GoToBack)
    }

    fun checkIfNewPlayOrMoreCards(message: Int) {
        if (message == R.string.do_you_want_play_again) {
            doAction(Event.ShowNumber1(""))
            doAction(Event.ShowNumber2(""))
            doAction(Event.ShowNumber3(""))
            getListNumberRandom()
        } else {
            saveListNumber()
        }
    }

    fun didOnClickCheck() {
        doAction(Event.ShowDialogCheck(listNumberComeOut))
        pauseAudio()
    }

    fun closeDialog() {
        if (dialogRate && time < 2) {
            numberRate -= 1
            Prefs.saveClickRate(sharedPref2, numberRate)
            if (numberRate <= 0) {
                Prefs.saveClickRate(sharedPref2, 8L)
                Prefs.saveTime(sharedPref2, time + 1)
                doAction(Event.ShowDialogRate)
            }
        }
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