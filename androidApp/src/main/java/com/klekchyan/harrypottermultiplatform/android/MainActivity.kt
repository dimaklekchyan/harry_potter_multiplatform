package com.klekchyan.harrypottermultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.klekchyan.harrypottermultiplatform.android.screen.MainScreen
import com.klekchyan.harrypottermultiplatform.android.ui.MyApplicationTheme
import com.klekchyan.harrypottermultiplatform.android.vm.MainScreenViewModel

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
