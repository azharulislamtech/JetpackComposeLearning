package com.me.compose.feature.six_interactions.presentation.carddialogsnackbar.ui.screens

import androidx.lifecycle.ViewModel
import com.me.compose.feature.six_interactions.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CarddialogsnackbarViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        // Preload dummy user
        _uiState.value = MainUiState(
            user = User(1, "Azharul Islam", "Senior Android Developer", "https://i.pravatar.cc/300")
        )
    }

    fun onCardClicked() {
        _uiState.update { it.copy(showDialog = true) }
    }

    fun onDialogDismiss() {
        _uiState.update { it.copy(showDialog = false) }
    }

    fun onDeleteConfirmed() {
        _uiState.update {
            it.copy(
                showDialog = false,
                showSnackbar = true
            )
        }
    }

    fun onSnackbarShown() {
        _uiState.update { it.copy(showSnackbar = false) }
    }
}

data class MainUiState(
    val user: User? = null,
    val showDialog: Boolean = false,
    val showSnackbar: Boolean = false
)