package com.me.compose.feature.six_interactions.presentation.animatedui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.me.compose.feature.six_interactions.presentation.animatedui.ui.screens.AnimatedUIScreen
import com.me.compose.feature.six_interactions.presentation.animatedui.ui.screens.AnimatedUiViewModel
import com.me.compose.feature.six_interactions.presentation.animatedui.ui.theme.AnimatedUiTheme

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AnimatedUI() {
    AnimatedUiTheme {
        AnimatedUIScreen(viewModel = AnimatedUiViewModel())
    }
}