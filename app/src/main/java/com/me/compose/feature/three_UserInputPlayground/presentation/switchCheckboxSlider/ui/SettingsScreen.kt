package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components.BrightnessSlider
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components.MusicPreferences
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components.ToggleControls
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components.VolumeSlider
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.viewmodel.SettingsViewModel

import kotlin.math.roundToInt

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    val backgroundColor = Color.hsl(210f, 0.5f, state.brightness)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        ToggleControls(
            isEnabled = state.isSettingEnabled,
            onToggle = viewModel::toggleSetting,
            isChecked = state.isAgreementChecked,
            onCheck = viewModel::checkAgreement
        )

        Spacer(Modifier.height(24.dp))

        VolumeSlider(volume = state.volume, onVolumeChange = viewModel::updateVolume)

        Spacer(Modifier.height(24.dp))

        MusicPreferences(
            selectedGenres = state.selectedGenres,
            onGenreToggle = viewModel::toggleGenre
        )

        Spacer(Modifier.height(24.dp))

        BrightnessSlider(brightness = state.brightness, onBrightnessChange = viewModel::updateBrightness)
    }
}
