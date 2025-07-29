package com.me.compose.feature.eight_reusables.DesignSystemSample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.screens.DesignSystemScreen

@Composable
fun DesignSystemSample(){
    Surface(modifier = Modifier.fillMaxSize()) {
        DesignSystemScreen()
    }
}