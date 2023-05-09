package com.klekchyan.harrypottermultiplatform.presentation

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.presentation.splash.SplashScreen
import org.kodein.di.compose.withDI

fun MainViewController() = ComposeUIViewController {
    withDI(Inject.di.di) {
        Navigator(SplashScreen)
    }
}