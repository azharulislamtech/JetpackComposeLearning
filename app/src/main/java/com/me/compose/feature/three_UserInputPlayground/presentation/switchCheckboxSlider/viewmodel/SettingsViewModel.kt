package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.viewmodel



import androidx.lifecycle.ViewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.state.SettingsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class SettingsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState

    fun toggleSetting(enabled: Boolean) {
        _uiState.value = _uiState.value.copy(isSettingEnabled = enabled)
    }

    fun checkAgreement(checked: Boolean) {
        _uiState.value = _uiState.value.copy(isAgreementChecked = checked)
    }

    fun updateVolume(volume: Float) {
        _uiState.value = _uiState.value.copy(volume = volume)
    }

    fun updateBrightness(brightness: Float) {
        _uiState.value = _uiState.value.copy(brightness = brightness)
    }

    fun toggleGenre(genre: String) {
        val current = _uiState.value.selectedGenres.toMutableSet()
        if (current.contains(genre)) current.remove(genre) else current.add(genre)
        _uiState.value = _uiState.value.copy(selectedGenres = current)
    }
}
