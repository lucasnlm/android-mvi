package dev.lucasnlm.mvi.viewmodel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform

fun <T> Flow<T?>.filterNotNull(): Flow<T> = transform { value ->
    value?.let {
        return@transform emit(it)
    }
}