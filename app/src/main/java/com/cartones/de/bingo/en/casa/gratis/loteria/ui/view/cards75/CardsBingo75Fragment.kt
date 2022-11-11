package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards75

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentCardsBingo75Binding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.GOOGLE_PLAY
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards75.CardsBingo75ViewModel.Event.*
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards.DialogRateApp


class CardsBingo75Fragment : BaseFragment(), DialogFragment75Check.OnClickListener,
    DialogRateApp.OnClickListener {

    private val viewModel: CardsBingo75ViewModel by viewModels()
    private lateinit var binding: FragmentCardsBingo75Binding
    private val args: CardsBingo75FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBingo75Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(viewModel)
        activity?.let { activity -> activity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) }
        viewModel.initFlow(requireActivity(), requireContext(), args.numberCard75)
        viewModel.eventsFlow.observe(viewLifecycleOwner, ::updateUi)
    }

    private fun updateUi(model: CardsBingo75ViewModel.Event) {
        when (model) {
            is SetUp -> {
                binding.imagePLay.setOnClickListener { viewModel.didOnClickPlay() }
                binding.imagePause.setOnClickListener { viewModel.didOnClickPause() }
                binding.imageMore.setOnClickListener { viewModel.didOnClickMore() }
                binding.imageLess.setOnClickListener { viewModel.didOnClickLess() }
                binding.imageRandom.setOnClickListener { viewModel.didOnclickRandom() }
                binding.imageMoreCards.setOnClickListener { viewModel.didOnClickCardsMore() }
                binding.imageCheck.setOnClickListener { viewModel.didOnClickCheck() }
            }
            is ShowCards -> binding.rVCards.adapter = CardsBingo75Adapter(model.numberCards)
            is ShowNumber1 -> binding.txtNumber1.text = model.number
            is ShowNumber2 -> binding.txtNumber2.text = model.number
            is ShowNumber3 -> binding.txtNumber3.text = model.number
            is ShowLoading -> binding.progressBar.isVisible = model.isVisibility
            is ShowPauseButton -> binding.imagePause.isVisible = model.isVisibility
            is ShowPlayButton -> binding.imagePLay.isVisible = model.isVisibility
            is ChangeSpeedNumber -> binding.textNumberSpeed.text = model.speedNumber
            is GoToBack -> findNavController().popBackStack()
            is ShowDialogCheck -> DialogFragment75Check(this, model.listNumbersComeOut).show(
                parentFragmentManager,
                null
            )
            is ShowDialog -> alertDialog(
                model.title,
                model.message,
                model.firstOption,
                model.secondOption
            )
            is ShowDialogRate -> {
                val rate = DialogRateApp(this)
                rate.show(parentFragmentManager, null)
            }
            is ShowToast -> Utils.toast(requireContext(), getString(model.resInt))
        }

    }

    private fun alertDialog(title: Int, message: Int, firstOption: Int, secondOption: Int) {
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(firstOption) { _, _ ->
                viewModel.checkIfNewPlayOrMoreCards(message)
            }
            .setNegativeButton(secondOption) { _, _ ->
            }
            .show()

    }

    override fun goToGooglePlay(start: Int) {
        if (start == 5 || start == 4) {
            val uri = Uri.parse(GOOGLE_PLAY)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        } else {
            Utils.toast(requireContext(), getString(R.string.dialog_rate_thank_you))
        }
    }

    override fun close() {
        viewModel.closeDialog()
    }

}