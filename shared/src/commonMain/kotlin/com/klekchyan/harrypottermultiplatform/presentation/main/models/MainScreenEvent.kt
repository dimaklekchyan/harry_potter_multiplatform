package com.klekchyan.harrypottermultiplatform.presentation.main.models

sealed class MainScreenEvent {
    object AllCharactersClick: MainScreenEvent()
    object StudentsClick: MainScreenEvent()
    object StaffClick: MainScreenEvent()
    class SpecificCharacterClick(val id: String): MainScreenEvent()
}
