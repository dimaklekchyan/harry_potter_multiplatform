package com.klekchyan.harrypottermultiplatform.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.klekchyan.harrypottermultiplatform.presentation.main.MainScreen
import kotlinx.coroutines.delay

internal object SplashScreen: Screen {
    @Composable
    override fun Content() {
        SplashScreenContent()
    }
}

@Composable
internal fun SplashScreenContent() {
    val navigator = LocalNavigator.currentOrThrow
    LaunchedEffect(Unit) {
        delay(1000)
        navigator.replace(MainScreen)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Splash screen")
    }
}