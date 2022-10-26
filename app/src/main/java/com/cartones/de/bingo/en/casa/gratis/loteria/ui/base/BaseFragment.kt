package com.cartones.de.bingo.en.casa.gratis.loteria.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cartones.de.bingo.en.casa.gratis.loteria.ui.common.extension.observe
import com.cartones.de.bingo.en.casa.gratis.loteria.R
import kotlinx.coroutines.flow.Flow

abstract class BaseFragment: Fragment() {

    private lateinit var eventsFlow: Flow<BaseEvent>
    private lateinit var baseProgressBar: BaseProgressBar


    override fun onDestroy() {
        if(::baseProgressBar.isInitialized) baseProgressBar.removeView()
        super.onDestroy()
    }

    fun init(baseViewModel: BaseViewModel) {
        this.eventsFlow = baseViewModel.baseEventsFlow
        this.eventsFlow.observe(viewLifecycleOwner, ::observeEvent)
        this.baseProgressBar = BaseProgressBar(activity, R.color.black)
    }

    private fun observeEvent(event: BaseEvent) {
        when(event) {
            is BaseEvent.ShowMessage -> context?.let { context ->  Toast.makeText(context, event.message, Toast.LENGTH_LONG).show() }
            is BaseEvent.ShowLoading -> showProgress(event.visibility)
        }
    }

    private fun showProgress(visibility: Boolean) {
        if (visibility) baseProgressBar.show() else baseProgressBar.hide()
    }
}