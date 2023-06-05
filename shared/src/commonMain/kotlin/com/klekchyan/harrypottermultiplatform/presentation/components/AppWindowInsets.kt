package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.ui.unit.Dp

expect class AppWindowInsets constructor(){
    val statusBarInset: Dp
    val navigationBarInset: Dp
}