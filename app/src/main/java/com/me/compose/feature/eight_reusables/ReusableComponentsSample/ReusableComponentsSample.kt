package com.me.compose.feature.eight_reusables.ReusableComponentsSample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.screens.ReusableComponentsScreen
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.theme.ReusableComponentsTheme


@Composable
fun ReusableComponentsSample() {
    ReusableComponentsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ReusableComponentsScreen()
        }
    }
}