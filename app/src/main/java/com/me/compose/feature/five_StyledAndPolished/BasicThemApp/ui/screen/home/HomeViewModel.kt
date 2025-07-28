package com.me.compose.feature.five_StyledAndPolished.BasicThemApp.ui.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow("Welcome to Material3 MVVM!")
    val uiState = _uiState.asStateFlow()
}