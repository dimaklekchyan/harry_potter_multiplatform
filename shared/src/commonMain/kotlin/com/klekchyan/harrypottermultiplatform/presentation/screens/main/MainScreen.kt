package com.klekchyan.harrypottermultiplatform.presentation.screens.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel

internal object MainScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel<MainScreenViewModel>()
        MainScreenContent(viewModel)
    }
}