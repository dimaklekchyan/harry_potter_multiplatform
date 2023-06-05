package com.klekchyan.harrypottermultiplatform.presentation.screens.character

import cafe.adriel.voyager.core.model.coroutineScope
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.presentation.baseEntity.BaseViewModel
import com.klekchyan.harrypottermultiplatform.presentation.screens.character.models.CharacterScreenAction
import com.klekchyan.harrypottermultiplatform.presentation.screens.character.models.CharacterScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.screens.character.models.CharacterScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterScreenViewModel(
    private val harryPotterRepository: HarryPotterRepository
): BaseViewModel<CharacterScreenState, CharacterScreenAction, CharacterScreenEvent>(
    initialState = CharacterScreenState(character = null, isLoading = true, error = null)
) {
    override fun obtainEvent(viewEvent: CharacterScreenEvent) {
        when(viewEvent) {
            is CharacterScreenEvent.GetCharacter -> {
                getCharacter(viewEvent.id)
            }
        }
    }

    private fun getCharacter(id: String) {
        coroutineScope.launch(Dispatchers.Default) {
            val character = harryPotterRepository.getSpecificCharacter(id)
            withContext(Dispatchers.Main) {
                viewState = viewState.copy(character = character, isLoading = false)
            }
        }
    }
}