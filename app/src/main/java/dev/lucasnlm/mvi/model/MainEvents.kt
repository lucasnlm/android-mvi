package dev.lucasnlm.mvi.model

sealed class MainEvent {
    object Click : MainEvent()
}
