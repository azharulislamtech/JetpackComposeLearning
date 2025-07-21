package com.me.compose.ui.components.surface

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SurfaceSection(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    AppCardSurface(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            title()
            Spacer(modifier = Modifier.height(12.dp))
            content()
        }
    }
}
