package com.me.compose.feature.six_interactions.presentation.motiondemo

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.me.compose.feature.six_interactions.presentation.motiondemo.ui.screens.MotiondemoScreen
import com.me.compose.feature.six_interactions.presentation.motiondemo.ui.screens.MotiondemoViewModel
import com.me.compose.feature.six_interactions.presentation.motiondemo.ui.screens.SplashScreen
import com.me.compose.feature.six_interactions.presentation.motiondemo.ui.theme.MotionDemoTheme


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun MotionDemo() {
    MotionDemoTheme {
        var showSplash by remember { mutableStateOf(true) }

        if (showSplash) {
            SplashScreen { showSplash = false }
        } else {
            MotiondemoScreen(viewModel = MotiondemoViewModel())
        }
    }
}