package com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.viewmodel

import androidx.lifecycle.ViewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.state.InputUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InputViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InputUiState())
    val uiState: StateFlow<InputUiState> = _uiState

    fun onNameChange(newName: String) {
        _uiState.value = _uiState.value.copy(name = newName)
    }

    fun onPasswordChange(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword)
    }

    fun onPasswordVisibilityToggle() {
        _uiState.value = _uiState.value.copy(
            isPasswordVisible = !_uiState.value.isPasswordVisible
        )
    }

    fun onNameFocusChanged(isFocused: Boolean) {
        _uiState.value = _uiState.value.copy(isNameFocused = isFocused)
    }

    fun onPasswordFocusChanged(isFocused: Boolean) {
        _uiState.value = _uiState.value.copy(isPasswordFocused = isFocused)
    }
}