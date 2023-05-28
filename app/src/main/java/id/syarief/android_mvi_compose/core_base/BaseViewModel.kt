package id.syarief.android_mvi_compose.core_base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class Reducer<S: State, E: Event>(initState: S) {
    private val _state: MutableStateFlow<S> = MutableStateFlow(initState)
    val state: StateFlow<S> = _state



}

interface State
interface Event