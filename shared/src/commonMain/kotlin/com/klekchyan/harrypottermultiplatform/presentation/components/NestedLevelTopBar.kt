package com.klekchyan.harrypottermultiplatform.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NestedLevelTopBar(
    modifier: Modifier = Modifier,
    onNavigateBackClick: () -> Unit,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black,
    title: String?,
    scale: Float = 1f
) {
    Box(
        modifier = modifier
            .background(backgroundColor)
            .requiredHeightIn(
                min = TopBarDefaults.minHeight * scale,
                max = TopBarDefaults.maxHeight * scale
            )
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.requiredWidth(16.dp))

            IconButton(onClick = { onNavigateBackClick() }) {
                Icon(
                    imageVector = Icons.Rounded.ChevronLeft,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.requiredWidth(16.dp))

            title?.let {
                Text(
                    text = it,
                    color = contentColor,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4,
                )
            }
        }
    }
}