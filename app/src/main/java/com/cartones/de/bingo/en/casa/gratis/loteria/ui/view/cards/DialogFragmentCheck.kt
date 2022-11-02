package com.cartones.de.bingo.en.casa.gratis.loteria.ui.view.cards

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.domains.models.NumberCard
import java.util.*


class DialogFragmentCheck(var listener: OnClickListener, val listNumbers: List<Int>): DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_fragment_check_number, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog?.findViewById<ImageView>(R.id.imageClose)?.setOnClickListener {
            dismiss()
            listener.close()
        }
        for (i in listNumbers.indices){
            when(listNumbers[i]){
                1-> dialog?.findViewById<ImageView>(R.id.image1)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                2-> dialog?.findViewById<ImageView>(R.id.image2)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                3-> dialog?.findViewById<ImageView>(R.id.image3)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                4-> dialog?.findViewById<ImageView>(R.id.image4)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                5-> dialog?.findViewById<ImageView>(R.id.image5)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                6-> dialog?.findViewById<ImageView>(R.id.image6)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                7-> dialog?.findViewById<ImageView>(R.id.image7)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                8-> dialog?.findViewById<ImageView>(R.id.image8)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                9-> dialog?.findViewById<ImageView>(R.id.image9)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                10-> dialog?.findViewById<ImageView>(R.id.image10)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                11-> dialog?.findViewById<ImageView>(R.id.image11)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                12-> dialog?.findViewById<ImageView>(R.id.image12)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                13-> dialog?.findViewById<ImageView>(R.id.image13)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                14-> dialog?.findViewById<ImageView>(R.id.image14)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                15-> dialog?.findViewById<ImageView>(R.id.image15)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                16-> dialog?.findViewById<ImageView>(R.id.image16)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                17-> dialog?.findViewById<ImageView>(R.id.image17)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                18-> dialog?.findViewById<ImageView>(R.id.image18)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                19-> dialog?.findViewById<ImageView>(R.id.image19)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                20-> dialog?.findViewById<ImageView>(R.id.image20)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                21-> dialog?.findViewById<ImageView>(R.id.image21)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                22-> dialog?.findViewById<ImageView>(R.id.image22)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                23-> dialog?.findViewById<ImageView>(R.id.image23)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                24-> dialog?.findViewById<ImageView>(R.id.image24)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                25-> dialog?.findViewById<ImageView>(R.id.image25)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                26-> dialog?.findViewById<ImageView>(R.id.image26)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                27-> dialog?.findViewById<ImageView>(R.id.image27)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                28-> dialog?.findViewById<ImageView>(R.id.image28)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                29-> dialog?.findViewById<ImageView>(R.id.image29)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                30-> dialog?.findViewById<ImageView>(R.id.image30)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                31-> dialog?.findViewById<ImageView>(R.id.image31)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                32-> dialog?.findViewById<ImageView>(R.id.image32)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                33-> dialog?.findViewById<ImageView>(R.id.image33)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                34-> dialog?.findViewById<ImageView>(R.id.image34)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                35-> dialog?.findViewById<ImageView>(R.id.image35)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                36-> dialog?.findViewById<ImageView>(R.id.image36)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                37-> dialog?.findViewById<ImageView>(R.id.image37)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                38-> dialog?.findViewById<ImageView>(R.id.image38)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                39-> dialog?.findViewById<ImageView>(R.id.image39)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                40-> dialog?.findViewById<ImageView>(R.id.image40)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                41-> dialog?.findViewById<ImageView>(R.id.image41)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                42-> dialog?.findViewById<ImageView>(R.id.image42)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                43-> dialog?.findViewById<ImageView>(R.id.image43)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                44-> dialog?.findViewById<ImageView>(R.id.image44)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                45-> dialog?.findViewById<ImageView>(R.id.image45)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                46-> dialog?.findViewById<ImageView>(R.id.image46)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                47-> dialog?.findViewById<ImageView>(R.id.image47)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                48-> dialog?.findViewById<ImageView>(R.id.image48)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                49-> dialog?.findViewById<ImageView>(R.id.image49)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                50-> dialog?.findViewById<ImageView>(R.id.image50)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                51-> dialog?.findViewById<ImageView>(R.id.image51)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                52-> dialog?.findViewById<ImageView>(R.id.image52)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                53-> dialog?.findViewById<ImageView>(R.id.image53)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                54-> dialog?.findViewById<ImageView>(R.id.image54)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                55-> dialog?.findViewById<ImageView>(R.id.image55)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                56-> dialog?.findViewById<ImageView>(R.id.image56)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                57-> dialog?.findViewById<ImageView>(R.id.image57)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                58-> dialog?.findViewById<ImageView>(R.id.image58)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                59-> dialog?.findViewById<ImageView>(R.id.image59)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                60-> dialog?.findViewById<ImageView>(R.id.image60)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                61-> dialog?.findViewById<ImageView>(R.id.image61)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                62-> dialog?.findViewById<ImageView>(R.id.image62)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                63-> dialog?.findViewById<ImageView>(R.id.image63)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                64-> dialog?.findViewById<ImageView>(R.id.image64)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                65-> dialog?.findViewById<ImageView>(R.id.image65)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                66-> dialog?.findViewById<ImageView>(R.id.image66)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                67-> dialog?.findViewById<ImageView>(R.id.image67)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                68-> dialog?.findViewById<ImageView>(R.id.image68)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                69-> dialog?.findViewById<ImageView>(R.id.image69)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                70-> dialog?.findViewById<ImageView>(R.id.image70)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                71-> dialog?.findViewById<ImageView>(R.id.image71)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                72-> dialog?.findViewById<ImageView>(R.id.image72)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                73-> dialog?.findViewById<ImageView>(R.id.image73)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                74-> dialog?.findViewById<ImageView>(R.id.image74)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                75-> dialog?.findViewById<ImageView>(R.id.image75)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                76-> dialog?.findViewById<ImageView>(R.id.image76)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                77-> dialog?.findViewById<ImageView>(R.id.image77)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                78-> dialog?.findViewById<ImageView>(R.id.image78)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                79-> dialog?.findViewById<ImageView>(R.id.image79)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                80-> dialog?.findViewById<ImageView>(R.id.image80)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                81-> dialog?.findViewById<ImageView>(R.id.image81)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                82-> dialog?.findViewById<ImageView>(R.id.image82)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                83-> dialog?.findViewById<ImageView>(R.id.image83)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                84-> dialog?.findViewById<ImageView>(R.id.image84)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                85-> dialog?.findViewById<ImageView>(R.id.image85)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                86-> dialog?.findViewById<ImageView>(R.id.image86)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                87-> dialog?.findViewById<ImageView>(R.id.image87)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                88-> dialog?.findViewById<ImageView>(R.id.image88)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                89-> dialog?.findViewById<ImageView>(R.id.image89)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)
                90-> dialog?.findViewById<ImageView>(R.id.image90)?.background = dialog?.context?.resources?.getDrawable(R.drawable.selected)

            }
        }
    }


    interface OnClickListener{
        fun close()
    }
}