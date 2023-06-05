package com.klekchyan.harrypottermultiplatform.presentation.baseEntity

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.random.Random

abstract class BaseAction {
    override fun equals(other: Any?): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return Random.nextInt()
    }
}

abstract class BaseViewModel<State : Any, Action: BaseAction, Event>(initialState: State): ScreenModel {
    private val _viewStates = MutableStateFlow(initialState)
    val viewStates: StateFlow<State> = _viewStates.asStateFlow()

    private val _viewActions = Channel<Action>(Channel.CONFLATED)
    val viewActions = _viewActions.receiveAsFlow()

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    abstract fun obtainEvent(viewEvent: Event)

    protected fun sendAction(action: Action) {
        coroutineScope.launch {
            _viewActions.send(action)
        }
    }
}