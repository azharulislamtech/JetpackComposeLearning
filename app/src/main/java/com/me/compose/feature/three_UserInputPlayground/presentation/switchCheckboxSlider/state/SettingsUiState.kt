package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.state

data class SettingsUiState(
    val isSettingEnabled: Boolean = false,
    val isAgreementChecked: Boolean = false,
    val volume: Float = 0.5f,
    val selectedGenres: Set<String> = emptySet(),
    val brightness: Float = 0.5f
)
