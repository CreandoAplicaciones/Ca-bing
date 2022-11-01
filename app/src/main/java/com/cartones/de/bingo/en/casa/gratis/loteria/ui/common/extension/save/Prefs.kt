package com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save

import android.content.SharedPreferences
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.FIRST_NUMBER_LIST
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.NUMBER_CARDS_LIST
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.SHARED_IS_FIRST_DAY
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Prefs {

    companion object {

        fun saveLists(sharedPref: SharedPreferences, list: List<NumberCard>) {
            val gson = Gson()
            val json = gson.toJson(list)//converting list to Json
            sharedPref.edit().putString(NUMBER_CARDS_LIST, json).apply()
        }

        fun getList(sharedPref: SharedPreferences): List<NumberCard> {
            val gson = Gson()
            val json = sharedPref.getString(NUMBER_CARDS_LIST, null)
            val type = object : TypeToken<List<NumberCard>>() {}.type
            return gson.fromJson(json, type)
        }

        fun saveFirstNumberList(sharedPref: SharedPreferences, number: Int) {
            sharedPref.edit().putInt(FIRST_NUMBER_LIST, number).apply()
        }

        fun getFirstNumberList(sharedPref: SharedPreferences): Int {
            return sharedPref.getInt(FIRST_NUMBER_LIST, 0)
        }

        fun saveFirstDay(sharedPref: SharedPreferences, isFirstDay: Boolean) {
            sharedPref.edit().putBoolean(SHARED_IS_FIRST_DAY, isFirstDay).apply()
        }

        fun getFirstDay(sharedPref: SharedPreferences): Boolean {
            return sharedPref.getBoolean(SHARED_IS_FIRST_DAY, false)
        }
    }
}