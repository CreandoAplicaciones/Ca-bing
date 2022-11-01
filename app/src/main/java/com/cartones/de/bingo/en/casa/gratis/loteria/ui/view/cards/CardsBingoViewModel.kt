package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.lifecycle.viewModelScope
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseViewModel
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save.Prefs
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule



class CardsBingoViewModel: BaseViewModel() {

    sealed class Event {
        object SetUp: Event()
        object GoToBack: Event()
        data class ShowDialogCheck(val listNumbersComeOut: List<Int>): Event()
        data class ShowCards(val numberCards: List<NumberCard>): Event()
        data class ShowNumber(val numberRandom: String): Event()
        data class ShowLoading(val isVisibility: Boolean): Event()
        data class ShowPlayButton(val isVisibility: Boolean): Event()
        data class ShowPauseButton(val isVisibility: Boolean): Event()
        data class ChangeSpeedNumber(val speedNumber: String): Event()
        data class ShowDialog(val title: Int, val message: Int, val firstOption: Int, val secondOption: Int): Event()
    }
    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val eventsFlow = eventChannel.receiveAsFlow()
    private lateinit var sharedPref: SharedPreferences
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: Context
    private var listNumbersRandom = listOf<Int>()
    private var numberOfTheList = 0
    private var ifContinue = true
    private var clickPlay = false
    private var speed = 3000L
    private var speedNumber = 3
    private lateinit var mediaPlayer: MediaPlayer
    private var listNumber: MutableList<NumberCard> = mutableListOf()
    private var listNumberComeOut: MutableList<Int> = mutableListOf()



    //region ViewModel Input
    fun initFlow(activity: Activity, context: Context, numberCard: NumberCard) {
        this.context = context
        listNumber.add(numberCard)
        doAction(Event.ShowCards(listNumber))
        sharedPref = activity.getPreferences(MODE_PRIVATE)
        listNumber = Prefs.getList(sharedPref).toMutableList()
        listNumber.add(numberCard)
        doAction(Event.ShowCards(listNumber))
        Prefs.saveLists(sharedPref, mutableListOf())
        getListNumberRandom()
    }

    private fun getListNumberRandom() {
        numberOfTheList = 0
        doAction(Event.ShowLoading(true))
        listNumbersRandom = Utils.getNumberRandom()
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
        clickPlay = true
        playNumber()
        doAction(Event.ShowPauseButton(true))
        doAction(Event.ShowPlayButton(false))
    }

    fun didOnClickPause() {
        pauseAudio()
    }

    private fun playNumber() {
        Timer().schedule(speed) {
            if (clickPlay) {
                playAudio(Utils.checkAudio(listNumbersRandom[numberOfTheList]))
                listNumberComeOut.add(listNumbersRandom[numberOfTheList])
                doAction(Event.ShowNumber(listNumbersRandom[numberOfTheList].toString()))
                checkIfContinueCounting()
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
        doAction(Event.ShowNumber(""))
    }

    fun didOnClickCardsMore() {
        doAction(Event.ShowDialog(R.string.bingo, R.string.do_you_want_more_cards, R.string.yes, R.string.no))
        pauseAudio()
    }

    private fun saveListNumber() {
        Prefs.saveLists(sharedPref, listNumber)
        goToBack()
    }

    private fun goToBack() {
        doAction(Event.GoToBack)
    }

    fun checkIfNewPlayOrMoreCards(message: Int) {
        if (message == R.string.do_you_want_play_again) {
            getListNumberRandom()
        } else {
            saveListNumber()
        }
    }

    fun didOnClickCheck() {
        doAction(Event.ShowDialogCheck(listNumberComeOut))
        pauseAudio()
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