package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.DarkColorScheme
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.LightColorScheme
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.theme.AppShapes
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.theme.AppTypography

@Composable
fun DesignSystemSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
