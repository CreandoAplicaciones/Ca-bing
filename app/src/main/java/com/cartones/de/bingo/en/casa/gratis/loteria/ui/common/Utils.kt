package com.cartones.de.bingo.en.casa.gratis.loteria.ui.common

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.widget.ImageView
import android.widget.Toast
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard75
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Delay
import kotlin.random.Random
import kotlin.random.nextInt

class Utils {

    companion object {

        fun numbers(): List<NumberCard> {

            return listOf(NumberCard(R.drawable.a0, R.drawable.a12,R.drawable.a27,R.drawable.a0,R.drawable.a0,R.drawable.a55,R.drawable.a60,R.drawable.a0,R.drawable.a82,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a0,R.drawable.a41,R.drawable.a56,R.drawable.a0,R.drawable.a74,R.drawable.a86,R.drawable.a2,R.drawable.a0,R.drawable.a0,R.drawable.a34,R.drawable.a42,R.drawable.a0,R.drawable.a68,R.drawable.a78,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a10,R.drawable.a22,R.drawable.a0,R.drawable.a0,R.drawable.a51,R.drawable.a0,R.drawable.a75,R.drawable.a85,R.drawable.a4,R.drawable.a0,R.drawable.a28,R.drawable.a32,R.drawable.a0,R.drawable.a52,R.drawable.a0,R.drawable.a76,R.drawable.a0,R.drawable.a0,R.drawable.a18,R.drawable.a0,R.drawable.a36,R.drawable.a44,R.drawable.a0,R.drawable.a64,R.drawable.a0,R.drawable.a88),
                NumberCard(R.drawable.a6,R.drawable.a0,R.drawable.a24,R.drawable.a0,R.drawable.a43,R.drawable.a0,R.drawable.a0,R.drawable.a71,R.drawable.a81,R.drawable.a0,R.drawable.a0,R.drawable.a25,R.drawable.a33,R.drawable.a0,R.drawable.a50,R.drawable.a63,R.drawable.a0,R.drawable.a87,R.drawable.a7,R.drawable.a16,R.drawable.a0,R.drawable.a39,R.drawable.a48,R.drawable.a0,R.drawable.a65,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a1,R.drawable.a11,R.drawable.a0,R.drawable.a0,R.drawable.a46,R.drawable.a0,R.drawable.a0,R.drawable.a70,R.drawable.a80,R.drawable.a0,R.drawable.a19,R.drawable.a0,R.drawable.a35,R.drawable.a47,R.drawable.a0,R.drawable.a62,R.drawable.a73,R.drawable.a0,R.drawable.a3,R.drawable.a0,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a57,R.drawable.a67,R.drawable.a0,R.drawable.a84),
                NumberCard(R.drawable.a0,R.drawable.a14,R.drawable.a0,R.drawable.a31,R.drawable.a40,R.drawable.a0,R.drawable.a61,R.drawable.a0,R.drawable.a83,R.drawable.a0,R.drawable.a0,R.drawable.a21,R.drawable.a38,R.drawable.a0,R.drawable.a53,R.drawable.a0,R.drawable.a77,R.drawable.a90,R.drawable.a9,R.drawable.a15,R.drawable.a0,R.drawable.a0,R.drawable.a45,R.drawable.a58,R.drawable.a0,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a5,R.drawable.a13,R.drawable.a0,R.drawable.a30,R.drawable.a0,R.drawable.a54,R.drawable.a66,R.drawable.a0,R.drawable.a0,R.drawable.a8,R.drawable.a0,R.drawable.a23,R.drawable.a37,R.drawable.a0,R.drawable.a0,R.drawable.a69,R.drawable.a0,R.drawable.a89,R.drawable.a0,R.drawable.a17,R.drawable.a26,R.drawable.a0,R.drawable.a49,R.drawable.a59,R.drawable.a0,R.drawable.a72,R.drawable.a0),
                NumberCard(R.drawable.a3,R.drawable.a15,R.drawable.a0,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a61,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a0,R.drawable.a20,R.drawable.a30,R.drawable.a0,R.drawable.a51,R.drawable.a0,R.drawable.a78,R.drawable.a84,R.drawable.a0,R.drawable.a19,R.drawable.a0,R.drawable.a32,R.drawable.a49,R.drawable.a0,R.drawable.a69,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a11,R.drawable.a25,R.drawable.a0,R.drawable.a43,R.drawable.a58,R.drawable.a0,R.drawable.a0,R.drawable.a86,R.drawable.a2,R.drawable.a0,R.drawable.a26,R.drawable.a31,R.drawable.a0,R.drawable.a0,R.drawable.a60,R.drawable.a76,R.drawable.a0,R.drawable.a9,R.drawable.a12,R.drawable.a0,R.drawable.a39,R.drawable.a0,R.drawable.a59,R.drawable.a62,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a8,R.drawable.a0,R.drawable.a22,R.drawable.a0,R.drawable.a0,R.drawable.a50,R.drawable.a0,R.drawable.a70,R.drawable.a83,R.drawable.a0,R.drawable.a10,R.drawable.a0,R.drawable.a34,R.drawable.a42,R.drawable.a0,R.drawable.a65,R.drawable.a77,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a23,R.drawable.a35,R.drawable.a0,R.drawable.a56,R.drawable.a68,R.drawable.a0,R.drawable.a87),
                NumberCard(R.drawable.a6,R.drawable.a18,R.drawable.a0,R.drawable.a0,R.drawable.a45,R.drawable.a0,R.drawable.a0,R.drawable.a71,R.drawable.a81,R.drawable.a7,R.drawable.a0,R.drawable.a27,R.drawable.a38,R.drawable.a0,R.drawable.a53,R.drawable.a66,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a0,R.drawable.a46,R.drawable.a55,R.drawable.a0,R.drawable.a74,R.drawable.a82),
                NumberCard(R.drawable.a1,R.drawable.a16,R.drawable.a0,R.drawable.a0,R.drawable.a44,R.drawable.a0,R.drawable.a64,R.drawable.a0,R.drawable.a89,R.drawable.a0,R.drawable.a0,R.drawable.a24,R.drawable.a36,R.drawable.a0,R.drawable.a52,R.drawable.a0,R.drawable.a72,R.drawable.a90,R.drawable.a0,R.drawable.a17,R.drawable.a28,R.drawable.a0,R.drawable.a48,R.drawable.a57,R.drawable.a0,R.drawable.a75,R.drawable.a0),
                NumberCard(R.drawable.a4,R.drawable.a0,R.drawable.a0,R.drawable.a33,R.drawable.a41,R.drawable.a0,R.drawable.a0,R.drawable.a73,R.drawable.a85,R.drawable.a0,R.drawable.a13,R.drawable.a21,R.drawable.a0,R.drawable.a0,R.drawable.a54,R.drawable.a63,R.drawable.a0,R.drawable.a88,R.drawable.a5,R.drawable.a14,R.drawable.a0,R.drawable.a37,R.drawable.a47,R.drawable.a0,R.drawable.a67,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a17,R.drawable.a22,R.drawable.a0,R.drawable.a0,R.drawable.a55,R.drawable.a67,R.drawable.a0,R.drawable.a85,R.drawable.a0,R.drawable.a0,R.drawable.a26,R.drawable.a0,R.drawable.a45,R.drawable.a57,R.drawable.a0,R.drawable.a75,R.drawable.a90,R.drawable.a8,R.drawable.a0,R.drawable.a0,R.drawable.a37,R.drawable.a49,R.drawable.a0,R.drawable.a68,R.drawable.a76,R.drawable.a0),
                NumberCard(R.drawable.a4,R.drawable.a0,R.drawable.a21,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a0,R.drawable.a71,R.drawable.a81,R.drawable.a0,R.drawable.a0,R.drawable.a25,R.drawable.a34,R.drawable.a0,R.drawable.a58,R.drawable.a64,R.drawable.a0,R.drawable.a83,R.drawable.a9,R.drawable.a15,R.drawable.a0,R.drawable.a39,R.drawable.a41,R.drawable.a0,R.drawable.a66,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a11,R.drawable.a0,R.drawable.a32,R.drawable.a42,R.drawable.a0,R.drawable.a65,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a0,R.drawable.a27,R.drawable.a33,R.drawable.a0,R.drawable.a50,R.drawable.a0,R.drawable.a77,R.drawable.a82,R.drawable.a2,R.drawable.a14,R.drawable.a0,R.drawable.a0,R.drawable.a47,R.drawable.a54,R.drawable.a0,R.drawable.a78,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a13,R.drawable.a23,R.drawable.a0,R.drawable.a0,R.drawable.a52,R.drawable.a0,R.drawable.a70,R.drawable.a84,R.drawable.a1,R.drawable.a0,R.drawable.a24,R.drawable.a30,R.drawable.a0,R.drawable.a53,R.drawable.a0,R.drawable.a79,R.drawable.a0,R.drawable.a0,R.drawable.a16,R.drawable.a0,R.drawable.a36,R.drawable.a44,R.drawable.a0,R.drawable.a69,R.drawable.a0,R.drawable.a88),
                NumberCard(R.drawable.a6,R.drawable.a18,R.drawable.a0,R.drawable.a0,R.drawable.a46,R.drawable.a0,R.drawable.a0,R.drawable.a72,R.drawable.a86,R.drawable.a0,R.drawable.a19,R.drawable.a0,R.drawable.a35,R.drawable.a48,R.drawable.a0,R.drawable.a60,R.drawable.a74,R.drawable.a0,R.drawable.a7,R.drawable.a0,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a59,R.drawable.a62,R.drawable.a0,R.drawable.a87),
                NumberCard(R.drawable.a2,R.drawable.a10,R.drawable.a0,R.drawable.a31,R.drawable.a0,R.drawable.a51,R.drawable.a61,R.drawable.a0,R.drawable.a0,R.drawable.a5,R.drawable.a0,R.drawable.a28,R.drawable.a38,R.drawable.a0,R.drawable.a0,R.drawable.a63,R.drawable.a0,R.drawable.a89,R.drawable.a0,R.drawable.a12,R.drawable.a29,R.drawable.a0,R.drawable.a43,R.drawable.a56,R.drawable.a0,R.drawable.a73,R.drawable.a0),
                NumberCard(R.drawable.a9,R.drawable.a14,R.drawable.a0,R.drawable.a0,R.drawable.a45,R.drawable.a0,R.drawable.a60,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a32,R.drawable.a0,R.drawable.a51,R.drawable.a0,R.drawable.a75,R.drawable.a90,R.drawable.a0,R.drawable.a18,R.drawable.a0,R.drawable.a34,R.drawable.a47,R.drawable.a0,R.drawable.a62,R.drawable.a78,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a11,R.drawable.a23,R.drawable.a0,R.drawable.a48,R.drawable.a54,R.drawable.a0,R.drawable.a0,R.drawable.a84,R.drawable.a5,R.drawable.a0,R.drawable.a28,R.drawable.a35,R.drawable.a0,R.drawable.a0,R.drawable.a66,R.drawable.a74,R.drawable.a0,R.drawable.a8,R.drawable.a12,R.drawable.a0,R.drawable.a37,R.drawable.a0,R.drawable.a58,R.drawable.a67,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a4,R.drawable.a0,R.drawable.a26,R.drawable.a0,R.drawable.a0,R.drawable.a52,R.drawable.a0,R.drawable.a73,R.drawable.a82,R.drawable.a0,R.drawable.a10,R.drawable.a0,R.drawable.a33,R.drawable.a42,R.drawable.a0,R.drawable.a61,R.drawable.a76,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a27,R.drawable.a39,R.drawable.a0,R.drawable.a56,R.drawable.a69,R.drawable.a0,R.drawable.a83),
                NumberCard(R.drawable.a3,R.drawable.a17,R.drawable.a0,R.drawable.a0,R.drawable.a43,R.drawable.a0,R.drawable.a0,R.drawable.a72,R.drawable.a88,R.drawable.a6,R.drawable.a0,R.drawable.a24,R.drawable.a30,R.drawable.a0,R.drawable.a55,R.drawable.a63,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a0,R.drawable.a25,R.drawable.a0,R.drawable.a49,R.drawable.a59,R.drawable.a0,R.drawable.a77,R.drawable.a89),
                NumberCard(R.drawable.a1,R.drawable.a13,R.drawable.a0,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a65,R.drawable.a0,R.drawable.a81,R.drawable.a0,R.drawable.a0,R.drawable.a21,R.drawable.a36,R.drawable.a0,R.drawable.a53,R.drawable.a0,R.drawable.a71,R.drawable.a87,R.drawable.a0,R.drawable.a15,R.drawable.a22,R.drawable.a0,R.drawable.a44,R.drawable.a57,R.drawable.a0,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a2,R.drawable.a0,R.drawable.a0,R.drawable.a31,R.drawable.a41,R.drawable.a0,R.drawable.a0,R.drawable.a70,R.drawable.a85,R.drawable.a0,R.drawable.a16,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a50,R.drawable.a64,R.drawable.a0,R.drawable.a86,R.drawable.a7,R.drawable.a19,R.drawable.a0,R.drawable.a38,R.drawable.a46,R.drawable.a0,R.drawable.a68,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a13,R.drawable.a24,R.drawable.a0,R.drawable.a0,R.drawable.a50,R.drawable.a60,R.drawable.a0,R.drawable.a82,R.drawable.a0,R.drawable.a0,R.drawable.a27,R.drawable.a0,R.drawable.a44,R.drawable.a54,R.drawable.a0,R.drawable.a74,R.drawable.a85,R.drawable.a7,R.drawable.a0,R.drawable.a0,R.drawable.a38,R.drawable.a46,R.drawable.a0,R.drawable.a65,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a10,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a55,R.drawable.a0,R.drawable.a75,R.drawable.a83,R.drawable.a8,R.drawable.a0,R.drawable.a26,R.drawable.a32,R.drawable.a0,R.drawable.a59,R.drawable.a0,R.drawable.a78,R.drawable.a0,R.drawable.a0,R.drawable.a11,R.drawable.a0,R.drawable.a34,R.drawable.a49,R.drawable.a0,R.drawable.a67,R.drawable.a0,R.drawable.a90),
                NumberCard(R.drawable.a1,R.drawable.a0,R.drawable.a23,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a0,R.drawable.a77,R.drawable.a81,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a37,R.drawable.a0,R.drawable.a51,R.drawable.a66,R.drawable.a0,R.drawable.a86,R.drawable.a3,R.drawable.a16,R.drawable.a0,R.drawable.a39,R.drawable.a48,R.drawable.a0,R.drawable.a68,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a2,R.drawable.a14,R.drawable.a0,R.drawable.a0,R.drawable.a45,R.drawable.a0,R.drawable.a0,R.drawable.a72,R.drawable.a88,R.drawable.a0,R.drawable.a17,R.drawable.a0,R.drawable.a31,R.drawable.a47,R.drawable.a0,R.drawable.a62,R.drawable.a73,R.drawable.a0,R.drawable.a4,R.drawable.a0,R.drawable.a25,R.drawable.a0,R.drawable.a0,R.drawable.a56,R.drawable.a69,R.drawable.a0,R.drawable.a89),
                NumberCard(R.drawable.a0,R.drawable.a12,R.drawable.a0,R.drawable.a30,R.drawable.a42,R.drawable.a0,R.drawable.a64,R.drawable.a0,R.drawable.a84,R.drawable.a0,R.drawable.a0,R.drawable.a21,R.drawable.a35,R.drawable.a0,R.drawable.a53,R.drawable.a0,R.drawable.a70,R.drawable.a87,R.drawable.a5,R.drawable.a15,R.drawable.a0,R.drawable.a0,R.drawable.a43,R.drawable.a57,R.drawable.a0,R.drawable.a71,R.drawable.a0),
                NumberCard(R.drawable.a6,R.drawable.a18,R.drawable.a0,R.drawable.a33,R.drawable.a0,R.drawable.a52,R.drawable.a61,R.drawable.a0,R.drawable.a0,R.drawable.a9,R.drawable.a0,R.drawable.a22,R.drawable.a36,R.drawable.a0,R.drawable.a0,R.drawable.a63,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a19,R.drawable.a28,R.drawable.a0,R.drawable.a41,R.drawable.a58,R.drawable.a0,R.drawable.a76,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a10,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a50,R.drawable.a61,R.drawable.a0,R.drawable.a87,R.drawable.a0,R.drawable.a0,R.drawable.a22,R.drawable.a0,R.drawable.a44,R.drawable.a59,R.drawable.a0,R.drawable.a72,R.drawable.a88,R.drawable.a6,R.drawable.a0,R.drawable.a0,R.drawable.a32,R.drawable.a47,R.drawable.a0,R.drawable.a64,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a2,R.drawable.a0,R.drawable.a27,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a0,R.drawable.a78,R.drawable.a84,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a33,R.drawable.a0,R.drawable.a51,R.drawable.a60,R.drawable.a0,R.drawable.a85,R.drawable.a7,R.drawable.a12,R.drawable.a0,R.drawable.a38,R.drawable.a49,R.drawable.a0,R.drawable.a65,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a14,R.drawable.a0,R.drawable.a35,R.drawable.a41,R.drawable.a0,R.drawable.a69,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a0,R.drawable.a25,R.drawable.a37,R.drawable.a0,R.drawable.a52,R.drawable.a0,R.drawable.a76,R.drawable.a82,R.drawable.a1,R.drawable.a15,R.drawable.a0,R.drawable.a0,R.drawable.a42,R.drawable.a57,R.drawable.a0,R.drawable.a77,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a11,R.drawable.a23,R.drawable.a0,R.drawable.a0,R.drawable.a54,R.drawable.a0,R.drawable.a74,R.drawable.a81,R.drawable.a5,R.drawable.a0,R.drawable.a28,R.drawable.a34,R.drawable.a0,R.drawable.a56,R.drawable.a0,R.drawable.a75,R.drawable.a0,R.drawable.a0,R.drawable.a13,R.drawable.a0,R.drawable.a39,R.drawable.a46,R.drawable.a0,R.drawable.a67,R.drawable.a0,R.drawable.a83),
                NumberCard(R.drawable.a3,R.drawable.a16,R.drawable.a0,R.drawable.a0,R.drawable.a43,R.drawable.a0,R.drawable.a0,R.drawable.a70,R.drawable.a89,R.drawable.a0,R.drawable.a17,R.drawable.a0,R.drawable.a31,R.drawable.a45,R.drawable.a0,R.drawable.a63,R.drawable.a73,R.drawable.a0,R.drawable.a4,R.drawable.a0,R.drawable.a26,R.drawable.a0,R.drawable.a0,R.drawable.a55,R.drawable.a66,R.drawable.a0,R.drawable.a90),
                NumberCard(R.drawable.a0,R.drawable.a10,R.drawable.a0,R.drawable.a31,R.drawable.a42,R.drawable.a0,R.drawable.a65,R.drawable.a0,R.drawable.a85,R.drawable.a0,R.drawable.a0,R.drawable.a27,R.drawable.a33,R.drawable.a0,R.drawable.a55,R.drawable.a0,R.drawable.a78,R.drawable.a88,R.drawable.a5,R.drawable.a15,R.drawable.a0,R.drawable.a0,R.drawable.a46,R.drawable.a59,R.drawable.a0,R.drawable.a79,R.drawable.a0),
                NumberCard(R.drawable.a3,R.drawable.a12,R.drawable.a0,R.drawable.a35,R.drawable.a0,R.drawable.a50,R.drawable.a60,R.drawable.a0,R.drawable.a0,R.drawable.a4,R.drawable.a0,R.drawable.a25,R.drawable.a39,R.drawable.a0,R.drawable.a0,R.drawable.a66,R.drawable.a0,R.drawable.a81,R.drawable.a0,R.drawable.a16,R.drawable.a28,R.drawable.a0,R.drawable.a45,R.drawable.a51,R.drawable.a0,R.drawable.a76,R.drawable.a0),
                NumberCard(R.drawable.a0,R.drawable.a18,R.drawable.a20,R.drawable.a0,R.drawable.a0,R.drawable.a53,R.drawable.a0,R.drawable.a73,R.drawable.a86,R.drawable.a6,R.drawable.a0,R.drawable.a21,R.drawable.a34,R.drawable.a0,R.drawable.a58,R.drawable.a0,R.drawable.a75,R.drawable.a0,R.drawable.a0,R.drawable.a19,R.drawable.a0,R.drawable.a36,R.drawable.a49,R.drawable.a0,R.drawable.a69,R.drawable.a0,R.drawable.a89),
                NumberCard(R.drawable.a2,R.drawable.a0,R.drawable.a24,R.drawable.a0,R.drawable.a43,R.drawable.a0,R.drawable.a0,R.drawable.a74,R.drawable.a82,R.drawable.a0,R.drawable.a0,R.drawable.a29,R.drawable.a30,R.drawable.a0,R.drawable.a52,R.drawable.a63,R.drawable.a0,R.drawable.a87,R.drawable.a7,R.drawable.a11,R.drawable.a0,R.drawable.a38,R.drawable.a48,R.drawable.a0,R.drawable.a67,R.drawable.a0,R.drawable.a0),
                NumberCard(R.drawable.a8,R.drawable.a14,R.drawable.a0,R.drawable.a0,R.drawable.a40,R.drawable.a0,R.drawable.a0,R.drawable.a71,R.drawable.a83,R.drawable.a0,R.drawable.a17,R.drawable.a0,R.drawable.a32,R.drawable.a42,R.drawable.a0,R.drawable.a62,R.drawable.a77,R.drawable.a0,R.drawable.a9,R.drawable.a0,R.drawable.a23,R.drawable.a0,R.drawable.a0,R.drawable.a56,R.drawable.a64,R.drawable.a0,R.drawable.a84),
                NumberCard(R.drawable.a0,R.drawable.a13,R.drawable.a22,R.drawable.a0,R.drawable.a0,R.drawable.a54,R.drawable.a61,R.drawable.a0,R.drawable.a80,R.drawable.a0,R.drawable.a0,R.drawable.a26,R.drawable.a0,R.drawable.a44,R.drawable.a57,R.drawable.a0,R.drawable.a70,R.drawable.a90,R.drawable.a1,R.drawable.a0,R.drawable.a0,R.drawable.a37,R.drawable.a47,R.drawable.a0,R.drawable.a68,R.drawable.a72,R.drawable.a0),
            )
        }

        fun numbers75(): List<NumberCard75> {
            return listOf(
                NumberCard75(R.drawable.a5,R.drawable.a27,R.drawable.a31,R.drawable.a47,R.drawable.a68,R.drawable.a2,R.drawable.a24,R.drawable.a38,R.drawable.a58,R.drawable.a71,R.drawable.a9,R.drawable.a20,R.drawable.a0,R.drawable.a60,R.drawable.a73,R.drawable.a4,R.drawable.a30,R.drawable.a37,R.drawable.a48,R.drawable.a72,R.drawable.a12,R.drawable.a16,R.drawable.a32,R.drawable.a56,R.drawable.a66),
                NumberCard75(R.drawable.a4,R.drawable.a29,R.drawable.a38,R.drawable.a57,R.drawable.a66,R.drawable.a14,R.drawable.a26,R.drawable.a45,R.drawable.a58,R.drawable.a73,R.drawable.a10,R.drawable.a17,R.drawable.a0,R.drawable.a53,R.drawable.a61,R.drawable.a11,R.drawable.a25,R.drawable.a34,R.drawable.a56,R.drawable.a67,R.drawable.a13,R.drawable.a23,R.drawable.a42,R.drawable.a51,R.drawable.a75),
                NumberCard75(R.drawable.a6,R.drawable.a29,R.drawable.a43,R.drawable.a57,R.drawable.a71,R.drawable.a12,R.drawable.a19,R.drawable.a44,R.drawable.a60,R.drawable.a72,R.drawable.a2,R.drawable.a24,R.drawable.a0,R.drawable.a47,R.drawable.a64,R.drawable.a5,R.drawable.a30,R.drawable.a37,R.drawable.a58,R.drawable.a75,R.drawable.a14,R.drawable.a28,R.drawable.a42,R.drawable.a56,R.drawable.a62),
                NumberCard75(R.drawable.a15,R.drawable.a21,R.drawable.a37,R.drawable.a56,R.drawable.a72,R.drawable.a8,R.drawable.a18,R.drawable.a31,R.drawable.a46,R.drawable.a69,R.drawable.a13,R.drawable.a24,R.drawable.a0,R.drawable.a48,R.drawable.a70,R.drawable.a5,R.drawable.a19,R.drawable.a39,R.drawable.a49,R.drawable.a62,R.drawable.a6,R.drawable.a22,R.drawable.a41,R.drawable.a57,R.drawable.a75),
                NumberCard75(R.drawable.a2,R.drawable.a16,R.drawable.a43,R.drawable.a50,R.drawable.a66,R.drawable.a12,R.drawable.a22,R.drawable.a44,R.drawable.a58,R.drawable.a61,R.drawable.a9,R.drawable.a29,R.drawable.a0,R.drawable.a47,R.drawable.a71,R.drawable.a11,R.drawable.a20,R.drawable.a31,R.drawable.a46,R.drawable.a70,R.drawable.a1,R.drawable.a20,R.drawable.a35,R.drawable.a51,R.drawable.a64),
                NumberCard75(R.drawable.a10,R.drawable.a30,R.drawable.a39,R.drawable.a52,R.drawable.a74,R.drawable.a6,R.drawable.a27,R.drawable.a36,R.drawable.a58,R.drawable.a62,R.drawable.a11,R.drawable.a17,R.drawable.a0,R.drawable.a50,R.drawable.a70,R.drawable.a4,R.drawable.a26,R.drawable.a40,R.drawable.a46,R.drawable.a63,R.drawable.a15,R.drawable.a24,R.drawable.a37,R.drawable.a56,R.drawable.a73),
                NumberCard75(R.drawable.a13,R.drawable.a21,R.drawable.a41,R.drawable.a47,R.drawable.a65,R.drawable.a1,R.drawable.a16,R.drawable.a40,R.drawable.a49,R.drawable.a75,R.drawable.a7,R.drawable.a18,R.drawable.a0,R.drawable.a53,R.drawable.a62,R.drawable.a4,R.drawable.a19,R.drawable.a43,R.drawable.a58,R.drawable.a68,R.drawable.a6,R.drawable.a29,R.drawable.a32,R.drawable.a50,R.drawable.a71),
                NumberCard75(R.drawable.a6,R.drawable.a20,R.drawable.a34,R.drawable.a57,R.drawable.a61,R.drawable.a3,R.drawable.a22,R.drawable.a31,R.drawable.a52,R.drawable.a63,R.drawable.a1,R.drawable.a28,R.drawable.a0,R.drawable.a55,R.drawable.a75,R.drawable.a8,R.drawable.a26,R.drawable.a36,R.drawable.a48,R.drawable.a70,R.drawable.a5,R.drawable.a19,R.drawable.a42,R.drawable.a46,R.drawable.a72),
                NumberCard75(R.drawable.a11,R.drawable.a29,R.drawable.a39,R.drawable.a51,R.drawable.a64,R.drawable.a6,R.drawable.a19,R.drawable.a38,R.drawable.a58,R.drawable.a66,R.drawable.a2,R.drawable.a21,R.drawable.a0,R.drawable.a46,R.drawable.a62,R.drawable.a12,R.drawable.a16,R.drawable.a35,R.drawable.a48,R.drawable.a75,R.drawable.a14,R.drawable.a18,R.drawable.a36,R.drawable.a49,R.drawable.a63),
                NumberCard75(R.drawable.a12,R.drawable.a29,R.drawable.a35,R.drawable.a47,R.drawable.a75,R.drawable.a4,R.drawable.a21,R.drawable.a39,R.drawable.a57,R.drawable.a61,R.drawable.a7,R.drawable.a30,R.drawable.a0,R.drawable.a59,R.drawable.a73,R.drawable.a6,R.drawable.a24,R.drawable.a42,R.drawable.a50,R.drawable.a67,R.drawable.a14,R.drawable.a20,R.drawable.a32,R.drawable.a60,R.drawable.a62),
                NumberCard75(R.drawable.a3,R.drawable.a16,R.drawable.a32,R.drawable.a50,R.drawable.a74,R.drawable.a6,R.drawable.a24,R.drawable.a40,R.drawable.a49,R.drawable.a71,R.drawable.a13,R.drawable.a19,R.drawable.a0,R.drawable.a48,R.drawable.a73,R.drawable.a5,R.drawable.a26,R.drawable.a34,R.drawable.a46,R.drawable.a68,R.drawable.a1,R.drawable.a17,R.drawable.a35,R.drawable.a59,R.drawable.a66),
                NumberCard75(R.drawable.a2,R.drawable.a30,R.drawable.a32,R.drawable.a49,R.drawable.a74,R.drawable.a7,R.drawable.a25,R.drawable.a43,R.drawable.a50,R.drawable.a68,R.drawable.a12,R.drawable.a19,R.drawable.a0,R.drawable.a46,R.drawable.a66,R.drawable.a8,R.drawable.a24,R.drawable.a44,R.drawable.a53,R.drawable.a63,R.drawable.a15,R.drawable.a17,R.drawable.a34,R.drawable.a59,R.drawable.a72),
                NumberCard75(R.drawable.a12,R.drawable.a23,R.drawable.a43,R.drawable.a50,R.drawable.a64,R.drawable.a14,R.drawable.a19,R.drawable.a32,R.drawable.a58,R.drawable.a61,R.drawable.a5,R.drawable.a27,R.drawable.a0,R.drawable.a53,R.drawable.a72,R.drawable.a15,R.drawable.a21,R.drawable.a34,R.drawable.a56,R.drawable.a68,R.drawable.a8,R.drawable.a28,R.drawable.a35,R.drawable.a49,R.drawable.a63),
                NumberCard75(R.drawable.a9,R.drawable.a20,R.drawable.a45,R.drawable.a46,R.drawable.a64,R.drawable.a6,R.drawable.a26,R.drawable.a44,R.drawable.a56,R.drawable.a70,R.drawable.a11,R.drawable.a25,R.drawable.a0,R.drawable.a57,R.drawable.a74,R.drawable.a3,R.drawable.a23,R.drawable.a41,R.drawable.a51,R.drawable.a62,R.drawable.a5,R.drawable.a30,R.drawable.a31,R.drawable.a49,R.drawable.a68),
                NumberCard75(R.drawable.a7,R.drawable.a19,R.drawable.a42,R.drawable.a53,R.drawable.a74,R.drawable.a3,R.drawable.a29,R.drawable.a39,R.drawable.a57,R.drawable.a66,R.drawable.a13,R.drawable.a24,R.drawable.a0,R.drawable.a60,R.drawable.a69,R.drawable.a12,R.drawable.a26,R.drawable.a37,R.drawable.a49,R.drawable.a75,R.drawable.a4,R.drawable.a27,R.drawable.a38,R.drawable.a59,R.drawable.a73),
                NumberCard75(R.drawable.a8,R.drawable.a19,R.drawable.a39,R.drawable.a60,R.drawable.a64,R.drawable.a13,R.drawable.a27,R.drawable.a38,R.drawable.a54,R.drawable.a62,R.drawable.a12,R.drawable.a30,R.drawable.a0,R.drawable.a53,R.drawable.a61,R.drawable.a10,R.drawable.a28,R.drawable.a40,R.drawable.a59,R.drawable.a66,R.drawable.a4,R.drawable.a24,R.drawable.a45,R.drawable.a49,R.drawable.a75),
                NumberCard75(R.drawable.a13,R.drawable.a26,R.drawable.a32,R.drawable.a58,R.drawable.a70,R.drawable.a12,R.drawable.a19,R.drawable.a41,R.drawable.a47,R.drawable.a64,R.drawable.a7,R.drawable.a24,R.drawable.a0,R.drawable.a56,R.drawable.a62,R.drawable.a5,R.drawable.a20,R.drawable.a35,R.drawable.a60,R.drawable.a71,R.drawable.a11,R.drawable.a17,R.drawable.a43,R.drawable.a55,R.drawable.a69),
                NumberCard75(R.drawable.a15,R.drawable.a26,R.drawable.a43,R.drawable.a46,R.drawable.a71,R.drawable.a5,R.drawable.a27,R.drawable.a36,R.drawable.a57,R.drawable.a62,R.drawable.a1,R.drawable.a17,R.drawable.a0,R.drawable.a48,R.drawable.a73,R.drawable.a10,R.drawable.a19,R.drawable.a38,R.drawable.a60,R.drawable.a63,R.drawable.a11,R.drawable.a28,R.drawable.a31,R.drawable.a56,R.drawable.a74),
                NumberCard75(R.drawable.a14,R.drawable.a20,R.drawable.a41,R.drawable.a46,R.drawable.a71,R.drawable.a12,R.drawable.a18,R.drawable.a34,R.drawable.a47,R.drawable.a74,R.drawable.a9,R.drawable.a22,R.drawable.a0,R.drawable.a53,R.drawable.a72,R.drawable.a3,R.drawable.a27,R.drawable.a40,R.drawable.a57,R.drawable.a64,R.drawable.a5,R.drawable.a26,R.drawable.a31,R.drawable.a56,R.drawable.a67),
                NumberCard75(R.drawable.a3,R.drawable.a22,R.drawable.a38,R.drawable.a46,R.drawable.a74,R.drawable.a6,R.drawable.a21,R.drawable.a40,R.drawable.a52,R.drawable.a62,R.drawable.a2,R.drawable.a24,R.drawable.a0,R.drawable.a53,R.drawable.a66,R.drawable.a13,R.drawable.a16,R.drawable.a43,R.drawable.a51,R.drawable.a69,R.drawable.a7,R.drawable.a23,R.drawable.a36,R.drawable.a59,R.drawable.a70),
                NumberCard75(R.drawable.a7,R.drawable.a21,R.drawable.a45,R.drawable.a52,R.drawable.a64,R.drawable.a9,R.drawable.a19,R.drawable.a40,R.drawable.a46,R.drawable.a74,R.drawable.a4,R.drawable.a29,R.drawable.a0,R.drawable.a48,R.drawable.a67,R.drawable.a3,R.drawable.a23,R.drawable.a44,R.drawable.a50,R.drawable.a73,R.drawable.a6,R.drawable.a30,R.drawable.a37,R.drawable.a49,R.drawable.a71),
                NumberCard75(R.drawable.a10,R.drawable.a27,R.drawable.a32,R.drawable.a59,R.drawable.a64,R.drawable.a5,R.drawable.a20,R.drawable.a36,R.drawable.a60,R.drawable.a63,R.drawable.a6,R.drawable.a29,R.drawable.a0,R.drawable.a46,R.drawable.a68,R.drawable.a3,R.drawable.a23,R.drawable.a38,R.drawable.a58,R.drawable.a62,R.drawable.a12,R.drawable.a17,R.drawable.a44,R.drawable.a49,R.drawable.a70),
                NumberCard75(R.drawable.a11,R.drawable.a23,R.drawable.a43,R.drawable.a54,R.drawable.a66,R.drawable.a1,R.drawable.a20,R.drawable.a36,R.drawable.a59,R.drawable.a61,R.drawable.a6,R.drawable.a26,R.drawable.a0,R.drawable.a50,R.drawable.a74,R.drawable.a7,R.drawable.a25,R.drawable.a31,R.drawable.a56,R.drawable.a72,R.drawable.a8,R.drawable.a28,R.drawable.a39,R.drawable.a51,R.drawable.a63),
                NumberCard75(R.drawable.a10,R.drawable.a26,R.drawable.a40,R.drawable.a48,R.drawable.a69,R.drawable.a12,R.drawable.a24,R.drawable.a36,R.drawable.a58,R.drawable.a63,R.drawable.a6,R.drawable.a22,R.drawable.a0,R.drawable.a52,R.drawable.a62,R.drawable.a2,R.drawable.a28,R.drawable.a42,R.drawable.a46,R.drawable.a74,R.drawable.a11,R.drawable.a25,R.drawable.a33,R.drawable.a53,R.drawable.a75),
                NumberCard75(R.drawable.a15,R.drawable.a22,R.drawable.a31,R.drawable.a47,R.drawable.a68,R.drawable.a2,R.drawable.a24,R.drawable.a33,R.drawable.a60,R.drawable.a63,R.drawable.a9,R.drawable.a19,R.drawable.a0,R.drawable.a51,R.drawable.a69,R.drawable.a6,R.drawable.a20,R.drawable.a41,R.drawable.a58,R.drawable.a70,R.drawable.a7,R.drawable.a16,R.drawable.a32,R.drawable.a53,R.drawable.a67),
                NumberCard75(R.drawable.a12,R.drawable.a17,R.drawable.a45,R.drawable.a48,R.drawable.a64,R.drawable.a5,R.drawable.a27,R.drawable.a31,R.drawable.a53,R.drawable.a74,R.drawable.a6,R.drawable.a23,R.drawable.a0,R.drawable.a51,R.drawable.a67,R.drawable.a11,R.drawable.a19,R.drawable.a34,R.drawable.a56,R.drawable.a66,R.drawable.a2,R.drawable.a30,R.drawable.a41,R.drawable.a49,R.drawable.a65),
                NumberCard75(R.drawable.a7,R.drawable.a30,R.drawable.a34,R.drawable.a58,R.drawable.a75,R.drawable.a12,R.drawable.a28,R.drawable.a42,R.drawable.a46,R.drawable.a63,R.drawable.a3,R.drawable.a18,R.drawable.a0,R.drawable.a47,R.drawable.a72,R.drawable.a11,R.drawable.a25,R.drawable.a32,R.drawable.a54,R.drawable.a71,R.drawable.a15,R.drawable.a19,R.drawable.a43,R.drawable.a60,R.drawable.a65),
                NumberCard75(R.drawable.a5,R.drawable.a18,R.drawable.a33,R.drawable.a58,R.drawable.a75,R.drawable.a4,R.drawable.a21,R.drawable.a44,R.drawable.a50,R.drawable.a74,R.drawable.a15,R.drawable.a17,R.drawable.a0,R.drawable.a54,R.drawable.a69,R.drawable.a2,R.drawable.a27,R.drawable.a35,R.drawable.a52,R.drawable.a64,R.drawable.a3,R.drawable.a29,R.drawable.a43,R.drawable.a60,R.drawable.a70),
                NumberCard75(R.drawable.a15,R.drawable.a29,R.drawable.a35,R.drawable.a54,R.drawable.a73,R.drawable.a13,R.drawable.a22,R.drawable.a42,R.drawable.a57,R.drawable.a70,R.drawable.a4,R.drawable.a30,R.drawable.a0,R.drawable.a46,R.drawable.a61,R.drawable.a1,R.drawable.a17,R.drawable.a32,R.drawable.a52,R.drawable.a75,R.drawable.a14,R.drawable.a20,R.drawable.a39,R.drawable.a58,R.drawable.a72),
                NumberCard75(R.drawable.a2,R.drawable.a21,R.drawable.a33,R.drawable.a57,R.drawable.a63,R.drawable.a5,R.drawable.a22,R.drawable.a31,R.drawable.a50,R.drawable.a68,R.drawable.a3,R.drawable.a28,R.drawable.a0,R.drawable.a53,R.drawable.a74,R.drawable.a11,R.drawable.a19,R.drawable.a32,R.drawable.a55,R.drawable.a67,R.drawable.a6,R.drawable.a18,R.drawable.a42,R.drawable.a48,R.drawable.a70),
                NumberCard75(R.drawable.a10,R.drawable.a18,R.drawable.a39,R.drawable.a52,R.drawable.a72,R.drawable.a14,R.drawable.a21,R.drawable.a34,R.drawable.a55,R.drawable.a61,R.drawable.a4,R.drawable.a23,R.drawable.a0,R.drawable.a60,R.drawable.a73,R.drawable.a2,R.drawable.a19,R.drawable.a45,R.drawable.a47,R.drawable.a74,R.drawable.a3,R.drawable.a24,R.drawable.a37,R.drawable.a57,R.drawable.a62),
                NumberCard75(R.drawable.a2,R.drawable.a21,R.drawable.a33,R.drawable.a52,R.drawable.a71,R.drawable.a10,R.drawable.a25,R.drawable.a31,R.drawable.a49,R.drawable.a68,R.drawable.a15,R.drawable.a16,R.drawable.a0,R.drawable.a48,R.drawable.a70,R.drawable.a9,R.drawable.a17,R.drawable.a35,R.drawable.a47,R.drawable.a61,R.drawable.a6,R.drawable.a18,R.drawable.a38,R.drawable.a56,R.drawable.a67),
                NumberCard75(R.drawable.a2,R.drawable.a27,R.drawable.a43,R.drawable.a51,R.drawable.a70,R.drawable.a6,R.drawable.a23,R.drawable.a33,R.drawable.a54,R.drawable.a65,R.drawable.a9,R.drawable.a18,R.drawable.a0,R.drawable.a52,R.drawable.a69,R.drawable.a10,R.drawable.a24,R.drawable.a44,R.drawable.a46,R.drawable.a72,R.drawable.a12,R.drawable.a28,R.drawable.a36,R.drawable.a55,R.drawable.a74),
                NumberCard75(R.drawable.a7,R.drawable.a19,R.drawable.a39,R.drawable.a51,R.drawable.a61,R.drawable.a11,R.drawable.a28,R.drawable.a37,R.drawable.a50,R.drawable.a67,R.drawable.a9,R.drawable.a29,R.drawable.a0,R.drawable.a58,R.drawable.a74,R.drawable.a2,R.drawable.a27,R.drawable.a43,R.drawable.a60,R.drawable.a73,R.drawable.a4,R.drawable.a24,R.drawable.a36,R.drawable.a46,R.drawable.a66),
                NumberCard75(R.drawable.a14,R.drawable.a21,R.drawable.a41,R.drawable.a52,R.drawable.a63,R.drawable.a11,R.drawable.a23,R.drawable.a39,R.drawable.a54,R.drawable.a75,R.drawable.a3,R.drawable.a24,R.drawable.a0,R.drawable.a49,R.drawable.a64,R.drawable.a13,R.drawable.a18,R.drawable.a43,R.drawable.a51,R.drawable.a74,R.drawable.a6,R.drawable.a26,R.drawable.a37,R.drawable.a48,R.drawable.a62),
                NumberCard75(R.drawable.a6,R.drawable.a27,R.drawable.a35,R.drawable.a56,R.drawable.a74,R.drawable.a13,R.drawable.a17,R.drawable.a42,R.drawable.a57,R.drawable.a68,R.drawable.a7,R.drawable.a24,R.drawable.a0,R.drawable.a58,R.drawable.a71,R.drawable.a10,R.drawable.a21,R.drawable.a44,R.drawable.a49,R.drawable.a61,R.drawable.a12,R.drawable.a20,R.drawable.a41,R.drawable.a59,R.drawable.a73),
                NumberCard75(R.drawable.a14,R.drawable.a19,R.drawable.a35,R.drawable.a49,R.drawable.a66,R.drawable.a2,R.drawable.a16,R.drawable.a32,R.drawable.a46,R.drawable.a70,R.drawable.a15,R.drawable.a18,R.drawable.a0,R.drawable.a56,R.drawable.a63,R.drawable.a8,R.drawable.a29,R.drawable.a33,R.drawable.a50,R.drawable.a75,R.drawable.a4,R.drawable.a20,R.drawable.a34,R.drawable.a51,R.drawable.a72),
                NumberCard75(R.drawable.a3,R.drawable.a23,R.drawable.a41,R.drawable.a55,R.drawable.a71,R.drawable.a4,R.drawable.a28,R.drawable.a43,R.drawable.a60,R.drawable.a61,R.drawable.a14,R.drawable.a27,R.drawable.a0,R.drawable.a49,R.drawable.a75,R.drawable.a13,R.drawable.a20,R.drawable.a39,R.drawable.a51,R.drawable.a68,R.drawable.a8,R.drawable.a26,R.drawable.a42,R.drawable.a56,R.drawable.a57),
                NumberCard75(R.drawable.a12,R.drawable.a17,R.drawable.a43,R.drawable.a49,R.drawable.a62,R.drawable.a4,R.drawable.a26,R.drawable.a35,R.drawable.a48,R.drawable.a71,R.drawable.a11,R.drawable.a18,R.drawable.a0,R.drawable.a46,R.drawable.a65,R.drawable.a10,R.drawable.a27,R.drawable.a45,R.drawable.a53,R.drawable.a73,R.drawable.a2,R.drawable.a28,R.drawable.a34,R.drawable.a47,R.drawable.a66),
                NumberCard75(R.drawable.a7,R.drawable.a30,R.drawable.a34,R.drawable.a52,R.drawable.a69,R.drawable.a2,R.drawable.a28,R.drawable.a44,R.drawable.a48,R.drawable.a61,R.drawable.a10,R.drawable.a23,R.drawable.a0,R.drawable.a56,R.drawable.a63,R.drawable.a14,R.drawable.a20,R.drawable.a36,R.drawable.a46,R.drawable.a65,R.drawable.a15,R.drawable.a19,R.drawable.a37,R.drawable.a54,R.drawable.a73),
                NumberCard75(R.drawable.a6,R.drawable.a25,R.drawable.a36,R.drawable.a50,R.drawable.a75,R.drawable.a4,R.drawable.a27,R.drawable.a45,R.drawable.a47,R.drawable.a68,R.drawable.a14,R.drawable.a18,R.drawable.a0,R.drawable.a48,R.drawable.a71,R.drawable.a8,R.drawable.a28,R.drawable.a31,R.drawable.a57,R.drawable.a64,R.drawable.a10,R.drawable.a21,R.drawable.a35,R.drawable.a60,R.drawable.a63),
                NumberCard75(R.drawable.a13,R.drawable.a18,R.drawable.a44,R.drawable.a49,R.drawable.a69,R.drawable.a7,R.drawable.a30,R.drawable.a35,R.drawable.a48,R.drawable.a70,R.drawable.a5,R.drawable.a17,R.drawable.a0,R.drawable.a52,R.drawable.a64,R.drawable.a8,R.drawable.a21,R.drawable.a38,R.drawable.a46,R.drawable.a75,R.drawable.a3,R.drawable.a29,R.drawable.a37,R.drawable.a54,R.drawable.a74),
                NumberCard75(R.drawable.a14,R.drawable.a19,R.drawable.a45,R.drawable.a47,R.drawable.a72,R.drawable.a10,R.drawable.a20,R.drawable.a31,R.drawable.a56,R.drawable.a62,R.drawable.a11,R.drawable.a22,R.drawable.a0,R.drawable.a46,R.drawable.a68,R.drawable.a15,R.drawable.a18,R.drawable.a34,R.drawable.a52,R.drawable.a73,R.drawable.a4,R.drawable.a30,R.drawable.a32,R.drawable.a57,R.drawable.a66),


                )
        }

        fun didClickNumberCards(clickIsTrue: Boolean, image: ImageView): Boolean {
            return if (clickIsTrue) {
                image.background = image.context.resources.getDrawable(R.drawable.small_outside_line)
                false
            } else {
                image.background = image.context.resources.getDrawable(R.drawable.selected)
                true
            }
        }

        fun getNumberRandom(): List<Int> {
            val random = List(9000) { Random.nextInt(1..90) }
                .distinct()
            return random
        }

        fun getNumberRandom75(): List<Int> {
            val random = List(9000) { Random.nextInt(1..75) }
                .distinct()
            return random
        }

        fun speed(speedNumber: Int):Long {
            return when(speedNumber) {
                0 -> 5400L
                1 -> 4600L
                2 -> 3800L
                3 -> 3000L
                4 -> 2200L
                5 -> 1400L
                6 -> 800L
                else -> 3000L
            }
        }
        fun checkAudio(number: Int): Int{
            return when (number){
                1-> R.raw.uno
                2-> R.raw.dos
                3-> R.raw.tres
                4-> R.raw.cuatro
                5-> R.raw.cinco
                6-> R.raw.seis
                7-> R.raw.siete
                8-> R.raw.ocho
                9-> R.raw.nueve
                10-> R.raw.diez
                11-> R.raw.once
                12-> R.raw.doce
                13-> R.raw.trece
                14-> R.raw.catorce
                15-> R.raw.quince
                16-> R.raw.dieciseis
                17-> R.raw.diecisiete
                18-> R.raw.dieciocho
                19-> R.raw.diecinueve
                20-> R.raw.veinte
                21-> R.raw.veitiuno
                22-> R.raw.veintidos
                23-> R.raw.veintitres
                24-> R.raw.veinticuatro
                25-> R.raw.veiticinco
                26-> R.raw.veintiseis
                27-> R.raw.veintisiete
                28-> R.raw.veintiocho
                29-> R.raw.veintinueve
                30-> R.raw.treinta
                31-> R.raw.treintiuno
                32-> R.raw.trentaidos
                33-> R.raw.trentaitres
                34-> R.raw.treinticuatro
                35-> R.raw.treinticinco
                36-> R.raw.treintayseis
                37-> R.raw.trentaysiete
                38-> R.raw.trentayocho
                39-> R.raw.treintaynueve
                40-> R.raw.cuarenta
                41-> R.raw.cuarentayuno
                42-> R.raw.cuarentaydos
                43-> R.raw.cuarentaytres
                44-> R.raw.cuarentaycuatro
                45-> R.raw.cuarentaycinco
                46-> R.raw.cuarentayseis
                47-> R.raw.cuarentaysiete
                48-> R.raw.cuarentayocho
                49-> R.raw.cuarentaynueve
                50-> R.raw.cincuenta
                51-> R.raw.cincuentayuno
                52-> R.raw.cincuentaydos
                53-> R.raw.cincuentaytres
                54-> R.raw.cincuentaycuatro
                55-> R.raw.cincuentaycinco
                56-> R.raw.cincuentayseis
                57-> R.raw.cincuentaysiete
                58-> R.raw.cincuentayocho
                59-> R.raw.cincuentaynueve
                60-> R.raw.sesenta
                61-> R.raw.sesentayuno
                62-> R.raw.sesentaydos
                63-> R.raw.sesentaytres
                64-> R.raw.sesentaycuatro
                65-> R.raw.sesentaycinco
                66-> R.raw.sesentayseis
                67-> R.raw.sesentaysiete
                68-> R.raw.sesentayocho
                69-> R.raw.sesentaynueve
                70-> R.raw.setenta
                71-> R.raw.setentayuno
                72-> R.raw.setentaydos
                73-> R.raw.setentaytres
                74-> R.raw.setentaycuatro
                75-> R.raw.setentaycinco
                76-> R.raw.setentayseis
                77-> R.raw.setentaysiete
                78-> R.raw.setentayocho
                79-> R.raw.setentaynueve
                80-> R.raw.ochenta
                81-> R.raw.ochentayuno
                82-> R.raw.ochentaydos
                83-> R.raw.ochentaytres
                84-> R.raw.ochentaycuatro
                85-> R.raw.ochentaycinco
                86-> R.raw.ochentayseis
                87-> R.raw.ochentaysiete
                88-> R.raw.ochentayocho
                89-> R.raw.ochentaynueve
                90-> R.raw.noventa
                else -> {R.raw.uno}
            }
        }


        fun checkAudioLetter(number: Int): Int{
            return when (number) {
                in 1..15 -> R.raw.b
                in 16..30 -> R.raw.i
                in 31..45 -> R.raw.n
                in 46..60 -> R.raw.g
                in 61..75 -> R.raw.o
                else -> R.raw.b
            }
        }


        fun toast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun shareApp(message:String, activity: Activity){
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            activity.startActivity(intent)
        }
    }
}



