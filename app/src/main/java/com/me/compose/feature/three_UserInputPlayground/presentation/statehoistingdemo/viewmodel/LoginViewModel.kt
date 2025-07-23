package com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.viewmodel



import androidx.lifecycle.ViewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.state.LoginUiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun submit() {
        // Handle form submission (e.g. validation, API call)
    }
}
