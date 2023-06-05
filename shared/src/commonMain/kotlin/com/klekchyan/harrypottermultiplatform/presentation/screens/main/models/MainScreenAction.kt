package com.klekchyan.harrypottermultiplatform.presentation.screens.main.models

import com.klekchyan.harrypottermultiplatform.presentation.baseEntity.BaseAction

sealed class MainScreenAction: BaseAction() {
    class OpenSpecificCharacter(val id: String): MainScreenAction()
}