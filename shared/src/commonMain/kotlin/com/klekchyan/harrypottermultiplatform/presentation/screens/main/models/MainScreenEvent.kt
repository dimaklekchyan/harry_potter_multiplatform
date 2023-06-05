package com.klekchyan.harrypottermultiplatform.presentation.screens.main.models

sealed class MainScreenEvent {
    class GetCharacters(val forceReload: Boolean): MainScreenEvent()
    class ChangeCharactersType(val type: CharactersType): MainScreenEvent()
    class SpecificCharacterClick(val id: String): MainScreenEvent()
}
