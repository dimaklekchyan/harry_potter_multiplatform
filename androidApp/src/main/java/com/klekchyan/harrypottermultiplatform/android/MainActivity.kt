package com.klekchyan.harrypottermultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.klekchyan.harrypottermultiplatform.android.ui.MyApplicationTheme
import com.klekchyan.harrypottermultiplatform.di.Inject.instance
import com.klekchyan.harrypottermultiplatform.repository.HarryPotterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val repository = instance<HarryPotterRepository>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var charactersAmount by remember { mutableStateOf(0) }

            LaunchedEffect(key1 = Unit) {
                lifecycleScope.launch(Dispatchers.IO) {
                    val characters = repository.getCharacters(true)
                    charactersAmount = characters.size
                }
            }

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Text(text = "$charactersAmount")
//                    MainScreen(vm = mainScreenViewModel)
                }
            }
        }
    }
}
