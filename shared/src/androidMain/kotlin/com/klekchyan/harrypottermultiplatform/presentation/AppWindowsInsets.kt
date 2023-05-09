package com.klekchyan.harrypottermultiplatform.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

actual class AppWindowInsets {
    actual val statusBarInset: Dp
        @Composable
        get() {
            return WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
        }
    actual val navigationBarInset: Dp
        @Composable
        get() {
            return WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()
        }
}