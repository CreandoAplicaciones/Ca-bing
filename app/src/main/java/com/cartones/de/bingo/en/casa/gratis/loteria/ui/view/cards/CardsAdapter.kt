package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ItemCardBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard


class CardsAdapter(private val numberCards: List<NumberCard>) : RecyclerView.Adapter<CardsAdapter.NumberCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NumberCardViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return numberCards.size
    }

    override fun onBindViewHolder(holder: NumberCardViewHolder, position: Int) {
        holder.bind(numberCards[position])
    }

    class NumberCardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(numberCard: NumberCard) = with(binding) {

           imageA1.setImageDrawable(ContextCompat.getDrawable(imageA1.context, numberCard.number1))
           imageA2.setImageDrawable(ContextCompat.getDrawable(imageA2.context, numberCard.number2))
           imageA3.setImageDrawable(ContextCompat.getDrawable(imageA3.context, numberCard.number3))
           imageA4.setImageDrawable(ContextCompat.getDrawable(imageA4.context, numberCard.number4))
           imageA5.setImageDrawable(ContextCompat.getDrawable(imageA5.context, numberCard.number5))
           imageA6.setImageDrawable(ContextCompat.getDrawable(imageA6.context, numberCard.number6))
           imageA7.setImageDrawable(ContextCompat.getDrawable(imageA7.context, numberCard.number7))
           imageA8.setImageDrawable(ContextCompat.getDrawable(imageA8.context, numberCard.number8))
           imageA9.setImageDrawable(ContextCompat.getDrawable(imageA9.context, numberCard.number9))
           imageB1.setImageDrawable(ContextCompat.getDrawable(imageB1.context, numberCard.number10))
           imageB2.setImageDrawable(ContextCompat.getDrawable(imageB2.context, numberCard.number11))
           imageB3.setImageDrawable(ContextCompat.getDrawable(imageB3.context, numberCard.number12))
           imageB4.setImageDrawable(ContextCompat.getDrawable(imageB4.context, numberCard.number13))
           imageB5.setImageDrawable(ContextCompat.getDrawable(imageB5.context, numberCard.number14))
           imageB6.setImageDrawable(ContextCompat.getDrawable(imageB6.context, numberCard.number15))
           imageB7.setImageDrawable(ContextCompat.getDrawable(imageB7.context, numberCard.number16))
           imageB8.setImageDrawable(ContextCompat.getDrawable(imageB8.context, numberCard.number17))
           imageB9.setImageDrawable(ContextCompat.getDrawable(imageB9.context, numberCard.number18))
           imageC1.setImageDrawable(ContextCompat.getDrawable(imageC1.context, numberCard.number19))
           imageC2.setImageDrawable(ContextCompat.getDrawable(imageC2.context, numberCard.number20))
           imageC3.setImageDrawable(ContextCompat.getDrawable(imageC3.context, numberCard.number21))
           imageC4.setImageDrawable(ContextCompat.getDrawable(imageC4.context, numberCard.number22))
           imageC5.setImageDrawable(ContextCompat.getDrawable(imageC5.context, numberCard.number23))
           imageC6.setImageDrawable(ContextCompat.getDrawable(imageC6.context, numberCard.number24))
           imageC7.setImageDrawable(ContextCompat.getDrawable(imageC7.context, numberCard.number25))
           imageC8.setImageDrawable(ContextCompat.getDrawable(imageC8.context, numberCard.number26))
           imageC9.setImageDrawable(ContextCompat.getDrawable(imageC9.context, numberCard.number27))

            var number1 = false
            imageA1.setOnClickListener{
                number1 = Utils.didClickNumberCards(number1, imageA1)
            }
            var number2 = false
            imageA2.setOnClickListener{
                number2 = Utils.didClickNumberCards(number2, imageA2)
            }
            var number3 = false
            imageA3.setOnClickListener{
                number3 = Utils.didClickNumberCards(number3, imageA3)
            }
            var number4 = false
            imageA4.setOnClickListener{
                number4 = Utils.didClickNumberCards(number4, imageA4)
            }
            var number5 = false
            imageA5.setOnClickListener{
                number5 = Utils.didClickNumberCards(number5, imageA5)
            }
            var number6 = false
            imageA6.setOnClickListener{
                number6 = Utils.didClickNumberCards(number6, imageA6)
            }
            var number7 = false
            imageA7.setOnClickListener{
                number7 = Utils.didClickNumberCards(number7, imageA7)
            }
            var number8 = false
            imageA8.setOnClickListener{
                number8 = Utils.didClickNumberCards(number8, imageA8)
            }
            var number9 = false
            imageA9.setOnClickListener{
                number9 = Utils.didClickNumberCards(number9, imageA9)
            }
            var number10 = false
            imageB1.setOnClickListener{
                number10 = Utils.didClickNumberCards(number10, imageB1)
            }
            var number11 = false
            imageB2.setOnClickListener{
                number11 = Utils.didClickNumberCards(number11, imageB2)
            }
            var number12 = false
            imageB3.setOnClickListener{
                number12 = Utils.didClickNumberCards(number12, imageB3)
            }
            var number13 = false
            imageB4.setOnClickListener{
                number13 = Utils.didClickNumberCards(number13, imageB4)
            }
            var number14 = false
            imageB5.setOnClickListener{
                number14 = Utils.didClickNumberCards(number14, imageB5)
            }
            var number15 = false
            imageB6.setOnClickListener{
                number15 = Utils.didClickNumberCards(number15, imageB6)
            }
            var number16 = false
            imageB7.setOnClickListener{
                number16 = Utils.didClickNumberCards(number16, imageB7)
            }
            var number17 = false
            imageB8.setOnClickListener{
                number17 = Utils.didClickNumberCards(number17, imageB8)
            }
            var number18 = false
            imageB9.setOnClickListener{
                number18 = Utils.didClickNumberCards(number18, imageB9)
            }
            var number19 = false
            imageC1.setOnClickListener{
                number19 = Utils.didClickNumberCards(number19, imageC1)
            }
            var number20 = false
            imageC2.setOnClickListener{
                number20 = Utils.didClickNumberCards(number20, imageC2)
            }
            var number21 = false
            imageC3.setOnClickListener{
                number21 = Utils.didClickNumberCards(number21, imageC3)
            }
            var number22 = false
            imageC4.setOnClickListener{
                number22 = Utils.didClickNumberCards(number22, imageC4)
            }
            var number23 = false
            imageC5.setOnClickListener{
                number23 = Utils.didClickNumberCards(number23, imageC5)
            }
            var number24 = false
            imageC6.setOnClickListener{
                number24 = Utils.didClickNumberCards(number24, imageC6)
            }
            var number25 = false
            imageC7.setOnClickListener{
                number25 = Utils.didClickNumberCards(number25, imageC7)
            }
            var number26 = false
            imageC8.setOnClickListener{
                number26 = Utils.didClickNumberCards(number26, imageC8)
            }
            var number27 = false
            imageC9.setOnClickListener{
                number27 = Utils.didClickNumberCards(number27, imageC9)
            }
        }
    }
}