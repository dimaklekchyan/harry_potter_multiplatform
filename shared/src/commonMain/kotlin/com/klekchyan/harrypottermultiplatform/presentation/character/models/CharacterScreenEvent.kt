package com.klekchyan.harrypottermultiplatform.presentation.character.models

sealed class CharacterScreenEvent {
    class GetCharacter(val id: String): CharacterScreenEvent()
}
