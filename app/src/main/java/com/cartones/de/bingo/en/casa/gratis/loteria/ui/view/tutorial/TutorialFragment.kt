package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.tutorial

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.cartones.de.bingo.en.casa.gratis.loteria.databinding.FragmentTutorialBinding
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.base.BaseFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.SHARED_NAME
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.save.Prefs
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.main.MainActivity

class TutorialFragment : BaseFragment() {

    private lateinit var binding: FragmentTutorialBinding
    private lateinit var viewModel: TutorialViewModel
    private lateinit var sharedPref: SharedPreferences


    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): TutorialFragment {
            return TutorialFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this)[TutorialViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 5)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTutorialBinding.inflate(inflater, container, false)

        val textView: TextView = binding.txtTutorialDescription
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = getString(it)
        }

        val imageView: ImageView = binding.iVTutorial
        viewModel.image.observe(viewLifecycleOwner) {
            imageView.setImageResource(it)
        }

        val button: Button = binding.btBegin
        viewModel.btn.observe(viewLifecycleOwner) {
            button.visibility = it
            binding.btBegin.setOnClickListener {
                viewModel.didClickOnClickBegin()
                sharedPref = requireContext().getSharedPreferences(SHARED_NAME,0)
                Prefs.saveFirstDay(sharedPref, true)
                startActivity(MainActivity.newIntent(requireContext()))}

        }

        return binding.root
    }
}