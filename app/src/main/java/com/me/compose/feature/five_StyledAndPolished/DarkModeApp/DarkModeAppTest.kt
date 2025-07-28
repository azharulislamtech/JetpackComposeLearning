package com.me.compose.feature.five_StyledAndPolished.DarkModeApp

import androidx.compose.runtime.Composable
import com.me.compose.feature.five_StyledAndPolished.DarkModeApp.ui.screens.DynamicModeScreen
import com.me.compose.feature.five_StyledAndPolished.DarkModeApp.ui.theme.DarkModeAppTheme


@Composable
fun DarkModeAppTest() {
    DarkModeAppTheme {
        DynamicModeScreen()
    }
}