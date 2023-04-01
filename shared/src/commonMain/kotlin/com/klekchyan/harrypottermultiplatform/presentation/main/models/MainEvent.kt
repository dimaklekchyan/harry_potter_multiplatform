package com.klekchyan.harrypottermultiplatform.presentation.main.models

sealed class MainEvent {
    object AllCharactersClick: MainEvent()
    object StudentsClick: MainEvent()
    object StaffClick: MainEvent()
    class SpecificCharacterClick(val id: String): MainEvent()
}
