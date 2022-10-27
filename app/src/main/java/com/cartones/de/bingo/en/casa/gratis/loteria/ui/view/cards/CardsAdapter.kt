package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.ItemCardBinding
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

            imageA1.setOnClickListener{ imageA1.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA2.setOnClickListener{ imageA2.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA3.setOnClickListener{ imageA3.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA4.setOnClickListener{ imageA4.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA5.setOnClickListener{ imageA5.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA6.setOnClickListener{ imageA6.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA7.setOnClickListener{ imageA7.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA8.setOnClickListener{ imageA8.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageA9.setOnClickListener{ imageA9.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB1.setOnClickListener{ imageB1.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB2.setOnClickListener{ imageB2.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB3.setOnClickListener{ imageB3.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB4.setOnClickListener{ imageB4.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB5.setOnClickListener{ imageB5.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB6.setOnClickListener{ imageB6.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB7.setOnClickListener{ imageB7.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB8.setOnClickListener{ imageB8.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageB9.setOnClickListener{ imageB9.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC1.setOnClickListener{ imageC1.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC2.setOnClickListener{ imageC2.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC3.setOnClickListener{ imageC3.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC4.setOnClickListener{ imageC4.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC5.setOnClickListener{ imageC5.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC6.setOnClickListener{ imageC6.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC7.setOnClickListener{ imageC7.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC8.setOnClickListener{ imageC8.background = imageA1.context.resources.getDrawable(R.drawable.selected) }
            imageC9.setOnClickListener{ imageC9.background = imageA1.context.resources.getDrawable(R.drawable.selected) }


        }
    }
}