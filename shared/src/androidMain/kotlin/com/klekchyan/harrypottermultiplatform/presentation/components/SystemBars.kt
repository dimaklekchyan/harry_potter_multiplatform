package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
actual fun SystemBars(statusBarColor: Color, navBarColor: Color, statusBarDarkIcons: Boolean, navBarDarkIcons: Boolean) {
    val systemUiController = rememberSystemUiController()

    DisposableEffect(systemUiController, statusBarDarkIcons, navBarDarkIcons) {
        systemUiController
            .setStatusBarColor(
                color = statusBarColor,
                darkIcons = statusBarDarkIcons
            )
        systemUiController
            .setNavigationBarColor(
                color = navBarColor,
                darkIcons = navBarDarkIcons,
                navigationBarContrastEnforced = false
            )

        onDispose {}
    }
}