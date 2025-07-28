package com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ThemeSwitcher(
    isDarkMode: Boolean,
    onToggle: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = if (isDarkMode) "Dark Mode" else "Light Mode")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(checked = isDarkMode, onCheckedChange = { onToggle() })
    }
}
