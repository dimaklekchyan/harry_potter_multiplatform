package com.klekchyan.harrypottermultiplatform.presentation.components.scaffold

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.klekchyan.harrypottermultiplatform.presentation.components.NestedLevelTopBar
import com.klekchyan.harrypottermultiplatform.presentation.components.TopBarDefaults
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme

@Composable
fun AppNestedScreenScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    isCollapsible: Boolean = true,
    backgroundColor: Color = AppTheme.colors.backgroundPrimary,
    topBarBackgroundColor: Color = AppTheme.colors.primary,
    topBarTitle: String? = null,
    topBarContentColor: Color = AppTheme.colors.onPrimary,
    onNavigateBackClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val topBarHeightPx = with(LocalDensity.current) { TopBarDefaults.minHeight.toPx() }
    val topBarOffsetHeightPx = remember { mutableStateOf(0f) }

    var isScrollingDown by remember { mutableStateOf(true) }
    val topBarScale by animateFloatAsState(
        if (isScrollingDown) 1f else 0f,
        animationSpec = tween(TopBarDefaults.scrollAnimationDuration)
    )

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                isScrollingDown = topBarOffsetHeightPx.value > -10f
                val newOffset = topBarOffsetHeightPx.value + delta
                topBarOffsetHeightPx.value = newOffset.coerceIn(-topBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    AppScaffold(
        modifier = modifier
            .background(topBarBackgroundColor)
            .nestedScroll(nestedScrollConnection),
        scaffoldState = scaffoldState,
        topBar = {
            NestedLevelTopBar(
                title = topBarTitle,
                backgroundColor = topBarBackgroundColor,
                contentColor = topBarContentColor,
                onNavigateBackClick = onNavigateBackClick,
                scale = if (isCollapsible) topBarScale else TopBarDefaults.defaultScale
            )
        },
        backgroundColor = topBarBackgroundColor,
        content = {
            Box(
                modifier = Modifier
                    .clip(
                        AppTheme.shapes.large.copy(
                            bottomStart = CornerSize(0.dp), bottomEnd = CornerSize(0.dp)
                        )
                    )
                    .fillMaxSize()
                    .background(backgroundColor)
            ) {
                content()
            }
        }
    )
}