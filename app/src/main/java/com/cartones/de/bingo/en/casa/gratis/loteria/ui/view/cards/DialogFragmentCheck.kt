package es.sixtema.handygym.ui.workouts.workoutencoder

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.RingtoneManager
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import es.sixtema.handygym.R
import java.util.*


class DialogFragmentCountdown(var listener: OnClickListener, val isContinue: Boolean): DialogFragment() {

    private var counter2: Int = 5

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        return inflater.inflate(R.layout.dialog_fragment_countdown, container, false)

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        dialog?.findViewById<TextView>(R.id.dialogTextNumber)?.text = counter2.toString()
        play()
    }

    private fun play(){
        object : CountDownTimer(6000,1000){
            override fun onFinish() {
                when(isContinue){
                    true -> {listener.continueWithExercises()
                        dismiss()
                    }
                    false -> {
                        listener.begin()
                        dismiss()
                    }
                }
            }
            override fun onTick(millisUntilFinished: Long) {
                dialog?.findViewById<TextView>(R.id.dialogTextNumber)?.text=(millisUntilFinished/1000).toString()
            }
        }.start()
    }

    interface OnClickListener{
        fun continueWithExercises()
        fun begin()
    }
}