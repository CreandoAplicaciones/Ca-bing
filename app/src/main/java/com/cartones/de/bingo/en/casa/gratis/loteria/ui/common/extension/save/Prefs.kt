package com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save

import android.content.SharedPreferences
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard75
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
            return if (json != null) {
                gson.fromJson(json, type)
            } else {
                emptyList()
            }
        }

        fun saveLists75(sharedPref: SharedPreferences, list: List<NumberCard75>) {
            val gson = Gson()
            val json = gson.toJson(list)//converting list to Json
            sharedPref.edit().putString(NUMBER_CARDS_LIST_75, json).apply()
        }

        fun getList75(sharedPref: SharedPreferences): List<NumberCard75> {
            val gson = Gson()
            val json = sharedPref.getString(NUMBER_CARDS_LIST_75, null)
            val type = object : TypeToken<List<NumberCard75>>() {}.type
            return if (json != null) {
                gson.fromJson(json, type)
            } else {
                emptyList()
            }
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

        fun saveClick(sharedPref: SharedPreferences, numberClick: Long){
            sharedPref.edit().putLong(SHARED_CLICK, numberClick).apply()
        }

        fun getClick(sharedPref: SharedPreferences):Long{
            return  sharedPref.getLong(SHARED_CLICK, 10)
        }

        fun saveClickRate(sharedPref: SharedPreferences, numberClick: Long){
            sharedPref.edit().putLong(SHARED_CLICK_RATE, numberClick).apply()
        }

        fun getClickRate(sharedPref: SharedPreferences):Long{
            return  sharedPref.getLong(SHARED_CLICK_RATE, 8L)
        }

        fun saveTime(sharedPref: SharedPreferences, time: Int){
            sharedPref.edit().putInt(SHARED_TIME, time).apply()
        }

        fun getTime(sharedPref: SharedPreferences):Int{
            return  sharedPref.getInt(SHARED_TIME, 0)
        }
    }
}