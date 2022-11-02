package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list75

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentCardsList75Binding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.GOOGLE_PLAY
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.Utils
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.list75.CardsList75ViewModel.Event.*


class CardsList75Fragment : BaseFragment() {

    private val viewModel: CardsList75ViewModel by viewModels()
    private lateinit var binding: FragmentCardsList75Binding
    private val adRequest = AdRequest.Builder().build()
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCardsList75Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.init(viewModel)
        viewModel.initFlow(requireContext())
        viewModel.eventsFlow.observe(viewLifecycleOwner, ::updateUi)
    }

    private fun updateUi(model: CardsList75ViewModel.Event) {
        when (model) {
            is SetUp -> binding.buttonShare.setOnClickListener { viewModel.didOnClickButtonShare() }
            is ShowCards ->{
                binding.rVCards.adapter = CardsList75Adapter (
                    { numberCard75 -> viewModel.onExerciseClicked(numberCard75)},
                    model.numberCards)
            }
            is InitialInterstitial -> {
                MobileAds.initialize(requireContext()) {}
                InterstitialAd.load(requireContext(),"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        mInterstitialAd = null
                    }

                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                    }
                })
                mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
                    override fun onAdClicked() {
                        // Called when a click is recorded for an ad.
                        Log.d(ContentValues.TAG, "Ad was clicked.")
                    }

                    override fun onAdDismissedFullScreenContent() {
                        // Called when ad is dismissed.
                        Log.d(ContentValues.TAG, "Ad dismissed fullscreen content.")
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        // Called when ad fails to show.
                        Log.e(ContentValues.TAG, "Ad failed to show fullscreen content.")
                        mInterstitialAd = null
                    }

                    override fun onAdImpression() {
                        // Called when an impression is recorded for an ad.
                        Log.d(ContentValues.TAG, "Ad recorded an impression.")
                    }

                    override fun onAdShowedFullScreenContent() {
                        // Called when ad is shown.
                        Log.d(ContentValues.TAG, "Ad showed fullscreen content.")
                    }
                }
            }
            is ShareApp -> Utils.shareApp(getString(model.ResInt, GOOGLE_PLAY), requireActivity())
            is GoToCardsBingo75 -> findNavController().navigate(CardsList75FragmentDirections.actionCardsList75FragmentToCardsBingo75Fragment(model.numberCard))
            is ShowInterstitial -> {
                if (mInterstitialAd != null && model.isVisible) {
                    mInterstitialAd?.show(requireActivity())
                    viewModel.showedInterstitial()
                }
            }
        }
    }
}