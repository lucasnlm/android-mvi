package dev.lucasnlm.mvi.viewmodel

import dev.lucasnlm.mvi.MainViewModel
import dev.lucasnlm.mvi.model.MainEvent
import dev.lucasnlm.mvi.model.MainState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@FlowPreview
@ExperimentalCoroutinesApi
class IntentViewModelTest {
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testInitialValue() = runBlockingTest {
        val viewModel = MainViewModel()
        assertEquals(MainState("Click me!"), viewModel.observeState().value)
    }

    @Test
    fun testClick() = runBlockingTest {
        val viewModel = MainViewModel()
        viewModel.sendEvent(MainEvent.Click)
        assertEquals(MainState("Clicked :)"), viewModel.observeState().value)
    }
}