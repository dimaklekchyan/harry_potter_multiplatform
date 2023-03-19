package com.klekchyan.harrypottermultiplatform.android.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.klekchyan.harrypottermultiplatform.android.vm.MainScreenViewModel

@Composable
fun MainScreen(
    vm: MainScreenViewModel
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            items(items = vm.characters, key = { character -> character.id }) { character ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(text = character.name)
                    Text(text = character.species)
                    character.wand?.let {  wand ->
                        Text(text = wand.wood)
                        Text(text = wand.core)
                        Text(text = "${wand.length}")
                    }
                }
            }
        }
    }
}