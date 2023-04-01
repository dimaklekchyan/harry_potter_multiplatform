package com.klekchyan.harrypottermultiplatform.ui.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import com.klekchyan.harrypottermultiplatform.presentation.main.MainScreenViewModel
import com.klekchyan.harrypottermultiplatform.presentation.main.models.MainEvent

@Composable
fun MainScreen() {
    StoredViewModel(factory = { MainScreenViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.obtainEvent(MainEvent.AllCharactersClick)
        }

        LazyColumn {
            items(items = viewState.value.characters, key = { it.id }) { character ->
                Text(character.name)
            }
        }
    }
}