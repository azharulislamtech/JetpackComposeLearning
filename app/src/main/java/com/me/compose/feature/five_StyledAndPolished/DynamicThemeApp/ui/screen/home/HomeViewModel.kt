package com.me.compose.feature.five_StyledAndPolished.DynamicThemeApp.ui.screen.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _message = MutableStateFlow("Welcome to Material3 Home!")
    val message = _message.asStateFlow()
}