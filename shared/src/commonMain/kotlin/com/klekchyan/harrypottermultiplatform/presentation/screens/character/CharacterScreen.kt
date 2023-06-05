package com.klekchyan.harrypottermultiplatform.presentation.screens.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.klekchyan.harrypottermultiplatform.presentation.components.SystemBars
import com.klekchyan.harrypottermultiplatform.presentation.screens.character.models.CharacterScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.components.scaffold.AppNestedScreenScaffold
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme

internal class CharacterScreen(val id: String): Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel<CharacterScreenViewModel>()
        CharacterScreenContent(id, viewModel)
    }
}

@Composable
internal fun CharacterScreenContent(id: String, vm: CharacterScreenViewModel) {
    val navigator = LocalNavigator.currentOrThrow

    val state = vm.viewStates.collectAsState()

    LaunchedEffect(Unit) {
        vm.obtainEvent(CharacterScreenEvent.GetCharacter(id))
    }

    SystemBars(
        statusBarColor = AppTheme.colors.primary,
        navBarColor = AppTheme.colors.backgroundPrimary,
        statusBarDarkIcons = false,
        navBarDarkIcons = true
    )

    AppNestedScreenScaffold(
        backgroundColor = AppTheme.colors.backgroundPrimary,
        topBarBackgroundColor = AppTheme.colors.primary,
        onNavigateBackClick = {
            navigator.pop()
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("${state.value.character?.name}")
        }
    }
}