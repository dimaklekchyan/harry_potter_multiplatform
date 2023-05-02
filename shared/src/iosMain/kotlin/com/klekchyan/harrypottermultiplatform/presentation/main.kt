package com.klekchyan.harrypottermultiplatform.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.presentation.splash.SplashScreen
import org.kodein.di.compose.withDI

fun MainViewController() = ComposeUIViewController {
    withDI(Inject.di.di) {
        Column {
            Box(
                modifier = Modifier.height(56.dp)
            )
            Navigator(SplashScreen)
        }
    }
}