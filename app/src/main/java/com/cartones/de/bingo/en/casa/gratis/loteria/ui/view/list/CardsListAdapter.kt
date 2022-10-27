package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ItemCardBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard


class CardsListAdapter(private val listener: (NumberCard) -> Unit, private val numberCards: List<NumberCard>) : RecyclerView.Adapter<CardsListAdapter.NumberCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NumberCardViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return numberCards.size
    }

    override fun onBindViewHolder(holder: NumberCardViewHolder, position: Int) {
        holder.bind(numberCards[position], listener)
    }

    class NumberCardViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(numberCard: NumberCard, listener: (NumberCard) -> Unit) = with(binding) {

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


            layout.setOnClickListener{listener(numberCard)}
        }
    }
}