package com.klekchyan.harrypottermultiplatform.presentation.main

import com.adeo.kviewmodel.BaseSharedViewModel
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainAction
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainEvent
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainScreenViewModel: BaseSharedViewModel<MainViewState, MainAction, MainEvent>(
    initialState = MainViewState(characters = emptyList(), isLoading = false, error = null)
) {

    private val repository: HarryPotterRepository = Inject.instance()

    override fun obtainEvent(viewEvent: MainEvent) {
        when(viewEvent) {
            is MainEvent.AllCharactersClick -> getAllCharacters()
            is MainEvent.StudentsClick -> getStudents()
            is MainEvent.StaffClick -> getStaff()
            is MainEvent.SpecificCharacterClick -> {}
        }
    }

    private fun getAllCharacters() {
        viewState = viewState.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                repository.getCharacters(true)
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(error = error.toString(), isLoading = false)
                }
            }.onSuccess { characters ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(characters = characters, isLoading = false, error = null)
                }
            }
        }
    }

    private fun getStudents() {
        viewState = viewState.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                repository.getStudents(true)
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(error = error.toString(), isLoading = false)
                }
            }.onSuccess { characters ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(characters = characters, isLoading = false, error = null)
                }
            }
        }
    }

    private fun getStaff() {
        viewState = viewState.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                repository.getStaff(true)
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(error = error.toString(), isLoading = false)
                }
            }.onSuccess { characters ->
                withContext(Dispatchers.Main) {
                    viewState = viewState.copy(characters = characters, isLoading = false, error = null)
                }
            }
        }
    }
}