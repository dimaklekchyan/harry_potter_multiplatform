package com.klekchyan.harrypottermultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.viewModelFactory
import com.klekchyan.harrypottermultiplatform.Greeting
import com.klekchyan.harrypottermultiplatform.android.screen.MainScreen
import com.klekchyan.harrypottermultiplatform.android.ui.MyApplicationTheme
import com.klekchyan.harrypottermultiplatform.android.vm.MainScreenViewModel
import com.klekchyan.harrypottermultiplatform.cache.Database
import com.klekchyan.harrypottermultiplatform.cache.DatabaseDriverFactory
import com.klekchyan.harrypottermultiplatform.network.HarryPotterApi

class MainActivity : ComponentActivity() {

    private val mainScreenViewModel by viewModels<MainScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(vm = mainScreenViewModel)
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
