package com.klekchyan.harrypottermultiplatform.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.kodein.rememberScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.klekchyan.harrypottermultiplatform.presentation.character.CharacterScreen
import com.klekchyan.harrypottermultiplatform.presentation.character.CharacterScreenContent
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainScreenEvent

internal object MainScreen: Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel<MainScreenViewModel>()
        MainScreenContent(viewModel)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun MainScreenContent(vm: MainScreenViewModel) {

    val navigator = LocalNavigator.currentOrThrow

    val viewState = vm.viewStates.collectAsState()

    LaunchedEffect(key1 = Unit) {
        vm.obtainEvent(MainScreenEvent.AllCharactersClick)
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
    ) {
        items(items = viewState.value.characters, key = { it.id }) { character ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                elevation = 2.dp,
                onClick = {
                    navigator.push(CharacterScreen(character.id))
                },
                content = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = character.name,
                        textAlign = TextAlign.Center
                    )
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}