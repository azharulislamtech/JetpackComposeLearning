package com.me.compose.feature.eight_reusables.ModifierExtensionsSample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.screens.ModifierExtensionsScreen
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.theme.ModifierExtensionsSampleTheme

@Composable
fun ModifierExtensionsSample(){
    ModifierExtensionsSampleTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ModifierExtensionsScreen()
        }
    }
}