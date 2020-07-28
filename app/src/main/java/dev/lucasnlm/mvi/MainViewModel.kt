package dev.lucasnlm.mvi

import dev.lucasnlm.mvi.model.MainEvent
import dev.lucasnlm.mvi.model.MainState
import dev.lucasnlm.mvi.viewmodel.IntentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.flow

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : IntentViewModel<MainEvent, MainState>() {
    override fun initialState() = MainState("Click me!")

    override suspend fun mapEventToState(event: MainEvent) = flow<MainState> {
        when (event) {
            is MainEvent.Click -> {
                emit(MainState("Clicked :)"))
            }
        }
    }
}
