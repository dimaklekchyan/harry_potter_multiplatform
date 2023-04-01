package com.klekchyan.harrypottermultiplatform.presentation.main.models

sealed class MainAction {
    class OpenSpecificCharacter(val id: String): MainAction()
}