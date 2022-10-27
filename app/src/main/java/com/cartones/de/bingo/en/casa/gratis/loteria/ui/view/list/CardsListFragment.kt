package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentCardsListBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list.CardsListViewModel.Event.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe


class CardsListFragment : BaseFragment() {

    private val viewModel: CardsListViewModel by viewModels()
    private lateinit var binding: FragmentCardsListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardsListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(viewModel)
        viewModel.initFlow()
        viewModel.eventsFlow.observe(viewLifecycleOwner, ::updateUi)
    }

    private fun updateUi(model: CardsListViewModel.Event) {
        when (model) {
            is ShowCards ->{
                binding.rVCards.adapter = CardsListAdapter (
                    { numberCard -> viewModel.onExerciseClicked(numberCard)},
                    model.numberCards)
            }
            is GoToCardsBingo -> TODO()
        }


    }
}