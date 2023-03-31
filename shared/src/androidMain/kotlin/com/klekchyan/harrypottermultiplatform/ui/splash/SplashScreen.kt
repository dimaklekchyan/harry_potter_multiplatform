package com.klekchyan.harrypottermultiplatform.ui.splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.klekchyan.harrypottermultiplatform.navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun SplashScreen() {
    Text("SplashScreen")
//    val rootController = LocalRootController.current
//    rootController.present(NavigationTree.Main.MainScreen.name)
}