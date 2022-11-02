package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards75

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ItemCard75Binding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard75


class CardsBingo75Adapter(private var numbersCards: List<NumberCard75>): RecyclerView.Adapter<CardsBingo75Adapter.ImagesHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ImagesHolder(ItemCard75Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        holder.bind(numbersCards[position])
        holder.setIsRecyclable(true)
    }

    override fun getItemCount(): Int = numbersCards.size

    class ImagesHolder(private val binding: ItemCard75Binding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(numberCard: NumberCard75) = with(binding) {
            imageA1.setImageDrawable(ContextCompat.getDrawable(imageA1.context, numberCard.number1))
            imageA2.setImageDrawable(ContextCompat.getDrawable(imageA2.context, numberCard.number2))
            imageA3.setImageDrawable(ContextCompat.getDrawable(imageA3.context, numberCard.number3))
            imageA4.setImageDrawable(ContextCompat.getDrawable(imageA4.context, numberCard.number4))
            imageA5.setImageDrawable(ContextCompat.getDrawable(imageA5.context, numberCard.number5))

            imageB1.setImageDrawable(ContextCompat.getDrawable(imageB1.context, numberCard.number6))
            imageB2.setImageDrawable(ContextCompat.getDrawable(imageB2.context, numberCard.number7))
            imageB3.setImageDrawable(ContextCompat.getDrawable(imageB3.context, numberCard.number8))
            imageB4.setImageDrawable(ContextCompat.getDrawable(imageB4.context, numberCard.number9))
            imageB5.setImageDrawable(ContextCompat.getDrawable(imageB5.context, numberCard.number10))

            imageC1.setImageDrawable(ContextCompat.getDrawable(imageC1.context, numberCard.number11))
            imageC2.setImageDrawable(ContextCompat.getDrawable(imageC2.context, numberCard.number12))
            imageC3.setImageDrawable(ContextCompat.getDrawable(imageC3.context, numberCard.number13))
            imageC4.setImageDrawable(ContextCompat.getDrawable(imageC4.context, numberCard.number14))
            imageC5.setImageDrawable(ContextCompat.getDrawable(imageC5.context, numberCard.number15))

            imageD1.setImageDrawable(ContextCompat.getDrawable(imageD1.context, numberCard.number16))
            imageD2.setImageDrawable(ContextCompat.getDrawable(imageD2.context, numberCard.number17))
            imageD3.setImageDrawable(ContextCompat.getDrawable(imageD3.context, numberCard.number18))
            imageD4.setImageDrawable(ContextCompat.getDrawable(imageD4.context, numberCard.number19))
            imageD5.setImageDrawable(ContextCompat.getDrawable(imageD5.context, numberCard.number20))

            imageF1.setImageDrawable(ContextCompat.getDrawable(imageF1.context, numberCard.number21))
            imageF2.setImageDrawable(ContextCompat.getDrawable(imageF2.context, numberCard.number22))
            imageF3.setImageDrawable(ContextCompat.getDrawable(imageF3.context, numberCard.number23))
            imageF4.setImageDrawable(ContextCompat.getDrawable(imageF4.context, numberCard.number24))
            imageF5.setImageDrawable(ContextCompat.getDrawable(imageF5.context, numberCard.number25))

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
            imageB1.setOnClickListener{
                number6 = Utils.didClickNumberCards(number6, imageB1)
            }
            var number7 = false
            imageB2.setOnClickListener{
                number7 = Utils.didClickNumberCards(number7, imageB2)
            }
            var number8 = false
            imageB3.setOnClickListener{
                number8 = Utils.didClickNumberCards(number8, imageB3)
            }
            var number9 = false
            imageB4.setOnClickListener{
                number9 = Utils.didClickNumberCards(number9, imageB4)
            }
            var number10 = false
            imageB5.setOnClickListener{
                number10 = Utils.didClickNumberCards(number10, imageB5)
            }

            var number11 = false
            imageC1.setOnClickListener{
                number11 = Utils.didClickNumberCards(number11, imageC1)
            }
            var number12 = false
            imageC2.setOnClickListener{
                number12 = Utils.didClickNumberCards(number12, imageC2)
            }
            var number13 = false
            imageC3.setOnClickListener{
                number13 = Utils.didClickNumberCards(number13, imageC3)
            }
            var number14 = false
            imageC4.setOnClickListener{
                number14 = Utils.didClickNumberCards(number14, imageC4)
            }
            var number15 = false
            imageC5.setOnClickListener{
                number15 = Utils.didClickNumberCards(number15, imageC5)
            }
            var number16 = false
            imageD1.setOnClickListener{
                number16 = Utils.didClickNumberCards(number16, imageD1)
            }
            var number17 = false
            imageD2.setOnClickListener{
                number17 = Utils.didClickNumberCards(number17, imageD2)
            }
            var number18 = false
            imageD3.setOnClickListener{
                number18 = Utils.didClickNumberCards(number18, imageD3)
            }
            var number19 = false
            imageD4.setOnClickListener{
                number19 = Utils.didClickNumberCards(number19, imageD4)
            }
            var number20 = false
            imageD5.setOnClickListener{
                number20 = Utils.didClickNumberCards(number20, imageD5)
            }
            var number21 = false
            imageF1.setOnClickListener{
                number21 = Utils.didClickNumberCards(number21, imageF1)
            }
            var number22 = false
            imageF2.setOnClickListener{
                number22 = Utils.didClickNumberCards(number22, imageF2)
            }
            var number23 = false
            imageF3.setOnClickListener{
                number23 = Utils.didClickNumberCards(number23, imageF3)
            }
            var number24 = false
            imageF4.setOnClickListener{
                number24 = Utils.didClickNumberCards(number24, imageF4)
            }
            var number25 = false
            imageF5.setOnClickListener{
                number25 = Utils.didClickNumberCards(number25, imageF5)
            }

        }

    }
}








