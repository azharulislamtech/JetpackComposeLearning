package com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.state

data class InputUiState(
    val name: String = "",
    val password: String = "",
    val isNameFocused: Boolean = false,
    val isPasswordFocused: Boolean = false,
    val isPasswordVisible: Boolean = false
) {
    val isFormValid: Boolean
        get() = name.isNotBlank() && password.isNotBlank()
}
