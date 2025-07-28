package com.me.compose.feature.five_StyledAndPolished.ThemePlayground

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.components.ThemeSwitcher
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.screens.ThemePlaygroundScreen
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.theme.ThemePlaygroundTheme

@Composable
fun ThemePlaygroundRoute(){
    var isDarkMode by rememberSaveable { mutableStateOf(false) }

    ThemePlaygroundTheme(darkTheme = isDarkMode) {
        Surface {
            Column {
                ThemeSwitcher(
                    isDarkMode = isDarkMode,
                    onToggle = { isDarkMode = !isDarkMode }
                )
                ThemePlaygroundScreen()
            }
        }
    }
}
