package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.math.roundToInt

@Composable
fun VolumeSlider(volume: Float, onVolumeChange: (Float) -> Unit) {
    Column {
        Text("Volume: ${(volume * 100).roundToInt()}%")
        Slider(value = volume, onValueChange = onVolumeChange)
    }
}
