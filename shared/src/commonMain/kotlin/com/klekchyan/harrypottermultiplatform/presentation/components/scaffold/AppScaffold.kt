package com.klekchyan.harrypottermultiplatform.presentation.components.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.klekchyan.harrypottermultiplatform.presentation.components.AppWindowInsets
import com.klekchyan.harrypottermultiplatform.presentation.components.SystemBars
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    backgroundColor: Color = AppTheme.colors.backgroundPrimary,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = modifier
            .background(backgroundColor)
            .padding(
                top = AppWindowInsets().statusBarInset,
                bottom = AppWindowInsets().navigationBarInset
            ),
        scaffoldState = scaffoldState,
        topBar = topBar,
        bottomBar = bottomBar,
        backgroundColor = backgroundColor,
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .consumeWindowInsets(innerPadding)
                    .padding(innerPadding),
            ) {
                content()
            }
        }
    )
}