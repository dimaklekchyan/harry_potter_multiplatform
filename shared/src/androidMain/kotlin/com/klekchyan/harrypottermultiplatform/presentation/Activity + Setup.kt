package com.klekchyan.harrypottermultiplatform.presentation

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cafe.adriel.voyager.navigator.Navigator
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.presentation.splash.SplashScreen
import org.kodein.di.compose.withDI

fun ComponentActivity.setupNavigation() {

    setContent {
        withDI(Inject.di.di) {
            TransparentSystemBars()
            Navigator(SplashScreen)
        }
    }
}