package dev.lucasnlm.mvi

import dev.lucasnlm.mvi.model.MainEvent
import dev.lucasnlm.mvi.model.MainState
import dev.lucasnlm.mvi.viewmodel.IntentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : IntentViewModel<MainEvent, MainState>() {
    override fun initialState() = MainState("Click me!")

    private val list = mutableListOf<Int>()
    private val init = System.currentTimeMillis()

    override suspend fun mapEventToState(event: MainEvent): MainState? {
        list.add((System.currentTimeMillis() - init).toInt())
        return when (event) {
            is MainEvent.Click -> MainState("Clicked :)")
        }
    }
}
