package com.me.compose.feature.five_StyledAndPolished.TestTheme.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define your light color scheme
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = White,
    primaryContainer = Purple90,
 //   onPrimaryContainer = Purple10,
    secondary = Orange40,
    onSecondary = White,
    secondaryContainer = Orange90,
 //   onSecondaryContainer = Orange10,
    tertiary = Blue40,
    onTertiary = White,
    tertiaryContainer = Blue90,
 //   onTertiaryContainer = Blue10,
    error = Red40,
    onError = White,
    errorContainer = Red90,
 //   onErrorContainer = Red10,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
    surfaceVariant = Grey90,
    onSurfaceVariant = Grey30,
    outline = Grey50,
    scrim = Black.copy(alpha = 0.5f),
    inverseSurface = Black,
    inverseOnSurface = White,
    inversePrimary = Purple80,
    surfaceDim = Grey80,
    surfaceBright = White,
    surfaceContainerLowest = White,
//    surfaceContainerLow = Grey95,
    surfaceContainer = Grey90,
    surfaceContainerHigh = Grey80,
  //  surfaceContainerHighest = Grey70,
)

// Define your dark color scheme
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
    surfaceVariant = Grey30,
    onSurfaceVariant = Grey80,
    outline = Grey60,
    scrim = Black.copy(alpha = 0.5f),
    inverseSurface = White,
    inverseOnSurface = Black,
    inversePrimary = Purple40,
    surfaceDim = Black,
    surfaceBright = Grey10,
    surfaceContainerLowest = Grey10,
    surfaceContainerLow = Grey20,
    surfaceContainer = Grey30,
 //   surfaceContainerHigh = Grey40,
    surfaceContainerHighest = Grey50,
)

@Composable
fun ThemeTestingAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Default to system setting
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Assuming you have a Typography.kt
        content = content
    )
}