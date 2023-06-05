package com.klekchyan.harrypottermultiplatform.presentation

import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.presentation.screens.splash.SplashScreen
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme
import org.kodein.di.compose.withDI

fun MainViewController() = ComposeUIViewController {
    AppTheme {
        withDI(Inject.di.di) {
            Navigator(SplashScreen)
        }
    }
}