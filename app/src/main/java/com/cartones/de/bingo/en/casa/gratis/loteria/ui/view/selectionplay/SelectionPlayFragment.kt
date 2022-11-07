package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.selectionplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentSelectionPlayBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.selectionplay.SelectionPlayViewModel.Event.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial.TutorialActivity


class SelectionPlayFragment : BaseFragment() {

    private val viewModel: SelectionPlayViewModel by viewModels()
    private lateinit var binding: FragmentSelectionPlayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSelectionPlayBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(viewModel)
            viewModel.initFlow()
            viewModel.eventsFlow.observe(viewLifecycleOwner, ::updateUi)
    }

    private fun updateUi(model: SelectionPlayViewModel.Event) {
        when (model) {
            is SetUp -> {
                binding.btn90.setOnClickListener { viewModel.didOnClickBtn90() }
                binding.btn75.setOnClickListener { viewModel.didOnClickBtn75() }
                binding.btnTutorial.setOnClickListener { viewModel.didOnClickBtnTutorial() }
            }
            is GoTo75 -> findNavController().navigate(SelectionPlayFragmentDirections.actionSelectionPlayFragmentToCardsList75Fragment())
            is GoTo90 -> findNavController().navigate(SelectionPlayFragmentDirections.actionSelectionPlayFragmentToCardsListFragment())
            is GoToTutorial -> startActivity(TutorialActivity.newIntent(requireContext()))
        }

    }


}