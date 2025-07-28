package com.me.compose.feature.six_interactions.presentation.animatedui.ui.screens

import androidx.lifecycle.ViewModel
import com.me.compose.feature.six_interactions.data.model.ViewMode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AnimatedUiViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    fun toggleInfoVisibility() {
        _uiState.update { it.copy(showInfo = !it.showInfo) }
    }

    fun toggleViewMode() {
        _uiState.update {
            it.copy(
                viewMode = if (it.viewMode == ViewMode.LIST) ViewMode.GRID else ViewMode.LIST
            )
        }
    }
}

data class MainUiState(
    val showInfo: Boolean = true,
    val viewMode: ViewMode = ViewMode.LIST
)