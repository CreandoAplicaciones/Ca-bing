package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list75

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ItemCard75Binding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard75


class CardsList75Adapter(private val listener: (NumberCard75) -> Unit, private val numberCards: List<NumberCard75>) : RecyclerView.Adapter<CardsList75Adapter.NumberCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NumberCardViewHolder(ItemCard75Binding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return numberCards.size
    }

    override fun onBindViewHolder(holder: NumberCardViewHolder, position: Int) {
        holder.bind(numberCards[position], listener)
    }

    class NumberCardViewHolder(private val binding: ItemCard75Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(numberCard: NumberCard75, listener: (NumberCard75) -> Unit) = with(binding) {

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


            layout.setOnClickListener{listener(numberCard)}
        }
    }
}