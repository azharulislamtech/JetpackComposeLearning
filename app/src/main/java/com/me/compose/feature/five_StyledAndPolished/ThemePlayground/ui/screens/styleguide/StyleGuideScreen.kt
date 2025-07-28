package com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.screens.styleguide

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StyleGuideScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Typography Preview", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        Text("Headline Large", style = MaterialTheme.typography.headlineLarge)
        Text("Title Medium", style = MaterialTheme.typography.titleMedium)
        Text("Body Small", style = MaterialTheme.typography.bodySmall)

        Spacer(Modifier.height(24.dp))
        Text("Color Preview", style = MaterialTheme.typography.titleMedium)

        val colors = MaterialTheme.colorScheme
        val colorSamples = listOf(
            "Primary" to colors.primary,
            "Secondary" to colors.secondary,
            "Background" to colors.background,
            "Surface" to colors.surface
        )

        colorSamples.forEach { (label, color) ->
            Surface(
                color = color,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = label,
                    modifier = Modifier.padding(8.dp),
                    color = contentColorFor(backgroundColor = color)
                )
            }
        }
    }
}
