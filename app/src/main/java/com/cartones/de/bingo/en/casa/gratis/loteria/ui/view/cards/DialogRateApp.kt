package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.R


class DialogRateApp(var listener: OnClickListener): DialogFragment() {

    var start = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_rate_app, container, false)


    }

    override fun onStart() {
        super.onStart()

        dialog?.findViewById<ImageView>(R.id.imgStart1)?.setOnClickListener {
            dialog?.findViewById<ImageView>(R.id.imgStart1)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart2)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart3)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart4)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart5)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<Button>(R.id.buttonAccept)?.isVisible = true
            dialog?.findViewById<Button>(R.id.buttonCancel)?.isVisible = true
            start = 1
        }

        dialog?.findViewById<ImageView>(R.id.imgStart2)?.setOnClickListener {
            dialog?.findViewById<ImageView>(R.id.imgStart1)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart2)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart3)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart4)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart5)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<Button>(R.id.buttonAccept)?.isVisible = true
            dialog?.findViewById<Button>(R.id.buttonCancel)?.isVisible = true
            start = 2
        }

        dialog?.findViewById<ImageView>(R.id.imgStart3)?.setOnClickListener {
            dialog?.findViewById<ImageView>(R.id.imgStart1)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart2)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart3)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart4)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<ImageView>(R.id.imgStart5)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<Button>(R.id.buttonAccept)?.isVisible = true
            dialog?.findViewById<Button>(R.id.buttonCancel)?.isVisible = true
            start = 3
        }

        dialog?.findViewById<ImageView>(R.id.imgStart4)?.setOnClickListener {
            dialog?.findViewById<ImageView>(R.id.imgStart1)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart2)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart3)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart4)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart5)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start_empty))
            dialog?.findViewById<Button>(R.id.buttonAccept)?.isVisible = true
            dialog?.findViewById<Button>(R.id.buttonCancel)?.isVisible = true
            start = 4
        }

        dialog?.findViewById<ImageView>(R.id.imgStart5)?.setOnClickListener {
            dialog?.findViewById<ImageView>(R.id.imgStart1)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart2)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart3)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart4)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<ImageView>(R.id.imgStart5)?.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.start))
            dialog?.findViewById<Button>(R.id.buttonAccept)?.isVisible = true
            dialog?.findViewById<Button>(R.id.buttonCancel)?.isVisible = true
            start = 5
        }
        dialog?.findViewById<Button>(R.id.buttonAccept)?.setOnClickListener {
            listener.goToGooglePlay(start)
            dismiss()
        }
        dialog?.findViewById<Button>(R.id.buttonCancel)?.setOnClickListener {
            dismiss()
        }
    }

    interface OnClickListener{
        fun goToGooglePlay(start: Int)
    }
}