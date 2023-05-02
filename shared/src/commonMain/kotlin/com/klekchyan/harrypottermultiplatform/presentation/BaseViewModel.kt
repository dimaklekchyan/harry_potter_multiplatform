package com.klekchyan.harrypottermultiplatform.presentation

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State): ScreenModel {
    private val _viewStates = MutableStateFlow(initialState)
    public val viewStates: StateFlow<State> = _viewStates.asStateFlow()

    private val _viewActions = MutableSharedFlow<Action?>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    public val viewActions: SharedFlow<Action?> = _viewActions.asSharedFlow()

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }

    protected var viewAction: Action?
        get() = _viewActions.replayCache.last()
        set(value) {
            _viewActions.tryEmit(value)
        }

    public abstract fun obtainEvent(viewEvent: Event)
}