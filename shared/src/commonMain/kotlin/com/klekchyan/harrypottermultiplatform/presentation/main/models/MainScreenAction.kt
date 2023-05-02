package com.klekchyan.harrypottermultiplatform.presentation.main.models

sealed class MainScreenAction {
    class OpenSpecificCharacter(val id: String): MainScreenAction()
}