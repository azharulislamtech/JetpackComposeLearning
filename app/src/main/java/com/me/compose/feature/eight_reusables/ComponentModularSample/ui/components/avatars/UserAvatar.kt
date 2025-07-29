package com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.avatars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * UserAvatar - A circular avatar with initials fallback
 */
@Composable
fun UserAvatar(name: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
    ) {
        Text(
            text = name.first().uppercase(),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
