package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color

//@Composable
//fun TransparentSystemBars(statusBarDarkIcons: Boolean = true, navBarDarkIcons: Boolean = true) {
//    val systemUiController = rememberSystemUiController()
//
//    DisposableEffect(systemUiController, statusBarDarkIcons, navBarDarkIcons) {
//        systemUiController
//            .setStatusBarColor(
//                color = Color.Transparent,
//                darkIcons = statusBarDarkIcons
//            )
//        systemUiController
//            .setNavigationBarColor(
//                color = Color.Transparent,
//                darkIcons = navBarDarkIcons,
//                navigationBarContrastEnforced = false
//            )
//
//        onDispose {}
//    }
//}