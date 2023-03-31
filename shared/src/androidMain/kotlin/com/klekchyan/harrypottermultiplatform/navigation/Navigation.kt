package com.klekchyan.harrypottermultiplatform.navigation

import com.klekchyan.harrypottermultiplatform.ui.main.CharacterScreen
import com.klekchyan.harrypottermultiplatform.ui.main.MainScreen
import com.klekchyan.harrypottermultiplatform.ui.splash.SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.generateGraph() {
    screen(NavigationTree.Splash.SplashScreen.name) {
        SplashScreen()
    }

    flow(NavigationTree.Main.MainFlow.name) {
        screen(NavigationTree.Main.MainScreen.name) {
            MainScreen()
        }
        screen(NavigationTree.Main.CharacterScreen.name) {
            CharacterScreen()
        }
    }
}