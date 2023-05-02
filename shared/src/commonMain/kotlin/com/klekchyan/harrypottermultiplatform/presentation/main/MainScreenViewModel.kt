package com.klekchyan.harrypottermultiplatform.presentation.main

import cafe.adriel.voyager.core.model.coroutineScope
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.presentation.BaseViewModel
import com.klekchyan.harrypottermultiplatform.presentation.character.models.CharacterScreenAction
import com.klekchyan.harrypottermultiplatform.presentation.character.models.CharacterScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.character.models.CharacterScreenState
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainScreenAction
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainScreenViewModel(
    private val repository: HarryPotterRepository
): BaseViewModel<MainScreenState, MainScreenAction, MainScreenEvent>(
    initialState = MainScreenState(
        characters = emptyList(),
        isLoading = true,
        error = null
    )
) {

    override fun obtainEvent(viewEvent: MainScreenEvent) {
        when(viewEvent) {
            is MainScreenEvent.AllCharactersClick -> getAllCharacters()
            is MainScreenEvent.StudentsClick -> getStudents()
            is MainScreenEvent.StaffClick -> getStaff()
            is MainScreenEvent.SpecificCharacterClick -> {}
        }
    }

    private fun getAllCharacters() {
        viewState = viewState.copy(isLoading = true)
        coroutineScope.launch(Dispatchers.Default) {
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
        coroutineScope.launch(Dispatchers.Default) {
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
        coroutineScope.launch(Dispatchers.Default) {
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