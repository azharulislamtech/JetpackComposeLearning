package com.me.compose.ui.components.surface

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun AppCardSurface(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    contentDescription: String? = null,
    role: Role? = null,
    containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 12.dp)
            .clip(MaterialTheme.shapes.medium)
            .then(
                if (onClick != null) {
                    Modifier
                        .clickable(
                            onClickLabel = contentDescription ?: "Clickable card"
                        ) {
                            onClick()
                        }
                } else Modifier
            )
            .semantics {
                contentDescription?.let { this.contentDescription = it }
                role?.let { this.role = it }
            },
        color = containerColor,
        contentColor = contentColor,
        shadowElevation = 4.dp
    ) {
        content()
    }
}
