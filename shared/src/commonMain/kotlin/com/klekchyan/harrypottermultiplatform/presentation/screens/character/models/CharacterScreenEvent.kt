package com.klekchyan.harrypottermultiplatform.presentation.screens.character.models

sealed class CharacterScreenEvent {
    class GetCharacter(val id: String): CharacterScreenEvent()
}
