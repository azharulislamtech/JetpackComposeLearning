package com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.me.compose.feature.five_StyledAndPolished.BasicThemApp.ui.theme.AppShapes
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.theme.AppTypography
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.theme.DarkColors
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.theme.LightColors


@Composable
fun ModifierExtensionsSampleTheme(content: @Composable () -> Unit) {
    val colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
