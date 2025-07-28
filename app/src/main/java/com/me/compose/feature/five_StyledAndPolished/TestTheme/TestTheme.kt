package com.me.compose.feature.five_StyledAndPolished.TestTheme

import android.view.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.me.compose.feature.five_StyledAndPolished.TestTheme.ui.screens.ThemeScreen
import com.me.compose.feature.five_StyledAndPolished.TestTheme.ui.theme.ThemeTestingAppTheme

@Composable
fun TestTheme() {
    // State to hold the user's explicit theme preference
    // Null means follow system, true means light, false means dark
    var userThemePreference by remember { mutableStateOf<Boolean?>(null) }

    // Determine if dark theme should be used based on system and user preference
    val useDarkTheme = when (userThemePreference) {
        true -> false // User explicitly chose light
        false -> true // User explicitly chose dark
        else -> androidx.compose.foundation.isSystemInDarkTheme() // Follow system
    }

    // Apply the custom theme
    ThemeTestingAppTheme(darkTheme = useDarkTheme) {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ThemeScreen(
                currentThemePreference = userThemePreference,
                onToggleTheme = { isLight ->
                    userThemePreference = isLight // Update user preference
                }
            )
        }
    }
}