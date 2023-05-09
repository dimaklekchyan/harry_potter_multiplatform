package com.klekchyan.harrypottermultiplatform.presentation.main.models

import com.klekchyan.harrypottermultiplatform.presentation.BaseAction

sealed class MainScreenAction: BaseAction() {
    class OpenSpecificCharacter(val id: String): MainScreenAction()
}