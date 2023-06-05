package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
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