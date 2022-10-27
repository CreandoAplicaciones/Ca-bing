package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentCardsBingoBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment

import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe


class CardsBingoFragment : BaseFragment() {

    private val viewModel: CardsBingoViewModel by viewModels()
    private lateinit var binding: FragmentCardsBingoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardsBingoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(viewModel)
        viewModel.initFlow()
        viewModel.eventsFlow.observe(viewLifecycleOwner, ::updateUi)
    }

    private fun updateUi(model: CardsBingoViewModel.Event) {
        when (model) {
            else -> {}
        }

    }
}