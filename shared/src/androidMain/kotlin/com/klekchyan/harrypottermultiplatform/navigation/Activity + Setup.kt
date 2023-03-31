package com.klekchyan.harrypottermultiplatform.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.RootController
import ru.alexgladkov.odyssey.compose.base.Navigator
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalNavigator
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.configuration.DefaultModalConfiguration
import ru.alexgladkov.odyssey.core.configuration.DisplayType

fun ComponentActivity.setupNavigation() {
    val rootController: RootController = RootComposeBuilder().apply { generateGraph() }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()

    setContent {
        CompositionLocalProvider(
            LocalRootController provides rootController
        ) {
            ModalNavigator(
                DefaultModalConfiguration(
                    backgroundColor = Color.White,
                    displayType = DisplayType.FullScreen
                )
            ) {
                Navigator(startScreen = NavigationTree.Splash.SplashScreen.name)
            }
        }
    }
}