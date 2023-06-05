package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.runtime.Composable
import com.klekchyan.harrypottermultiplatform.presentation.theme.colorTransparent

@Composable
fun TransparentSystemBars(statusBarDarkIcons: Boolean = true, navBarDarkIcons: Boolean = true) {
    SystemBars(colorTransparent, colorTransparent, statusBarDarkIcons, navBarDarkIcons)
}