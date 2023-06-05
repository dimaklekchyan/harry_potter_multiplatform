package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
expect fun SystemBars(statusBarColor: Color, navBarColor: Color, statusBarDarkIcons: Boolean, navBarDarkIcons: Boolean)