package com.klekchyan.harrypottermultiplatform.presentation.screens.main

import cafe.adriel.voyager.core.model.coroutineScope
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.presentation.baseEntity.BaseViewModel
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.CharactersType
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.MainScreenAction
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.MainScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainScreenViewModel(
    private val repository: HarryPotterRepository
): BaseViewModel<MainScreenState, MainScreenAction, MainScreenEvent>(
    initialState = MainScreenState()
) {

    private var allCharacters: List<Character> = emptyList()

    init {
        obtainEvent(MainScreenEvent.GetCharacters(true))
    }

    override fun obtainEvent(viewEvent: MainScreenEvent) {
        when(viewEvent) {
            is MainScreenEvent.GetCharacters -> {
                getCharacters(viewEvent.forceReload)
            }
            is MainScreenEvent.ChangeCharactersType -> {
                viewState = viewState.copy(characters = getCharacterByType(viewEvent.type))
            }
            is MainScreenEvent.SpecificCharacterClick -> {
                sendAction(MainScreenAction.OpenSpecificCharacter(viewEvent.id))
            }
        }
    }

    private fun getCharacters(forceReload: Boolean) {
        viewState = viewState.copy(isLoading = true)
        coroutineScope.launch(Dispatchers.Default) {
            repository.getCharacters(forceReload).collect { result ->
                withContext(Dispatchers.Main) {
                    result.onLoading {
                        viewState = viewState.copy(isLoading = true)
                    }
                    result.onError { exception ->
                        viewState = viewState.copy(isLoading = false, error = exception?.message)
                    }
                    result.onSuccess { characters ->
                        allCharacters = characters ?: emptyList()
                        viewState = viewState.copy(
                            isLoading = false,
                            characters = getCharacterByType(viewState.charactersType)
                        )
                    }
                }

            }
        }
    }

    private fun getCharacterByType(type: CharactersType): List<Character> {
        return when(type) {
            CharactersType.All -> allCharacters
            CharactersType.Students -> allCharacters.filter { it.hogwartsStudent }
            CharactersType.Staff -> allCharacters.filter { it.hogwartsStaff }
        }
    }
}