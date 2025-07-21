package com.me.compose.ui.components.spacer

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerGrid(
    units: Int = 1, // 1 unit = 8.dp by default
    direction: Orientation = Orientation.Vertical
) {
    val spacing = 8.dp * units
    Spacer(
        modifier = when (direction) {
            Orientation.Vertical -> Modifier.height(spacing)
            Orientation.Horizontal -> Modifier.width(spacing)
        }
    )
}
