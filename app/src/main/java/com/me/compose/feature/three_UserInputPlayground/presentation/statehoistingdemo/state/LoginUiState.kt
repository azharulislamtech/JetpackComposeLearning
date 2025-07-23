package com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.state



data class LoginUiState(
    val email: String = "",
    val password: String = ""
) {
    val isFormValid: Boolean
        get() = email.isNotBlank() && password.isNotBlank()
}

