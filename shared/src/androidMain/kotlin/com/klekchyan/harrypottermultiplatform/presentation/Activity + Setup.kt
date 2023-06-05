package com.klekchyan.harrypottermultiplatform.presentation

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.presentation.components.TransparentSystemBars
import com.klekchyan.harrypottermultiplatform.presentation.screens.splash.SplashScreen
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme
import org.kodein.di.compose.withDI

fun ComponentActivity.setupNavigation() {

    setContent {
        AppTheme {
            withDI(Inject.di.di) {
                Navigator(SplashScreen)
            }
        }
    }
}