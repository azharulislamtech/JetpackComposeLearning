package com.me.compose.feature.five_StyledAndPolished.DarkModeApp.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DynamicModeViewModel : ViewModel() {
    private val _message = MutableStateFlow("Dark Mode Test Ready")
    val message = _message.asStateFlow()
}