package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel: ViewModel() {
    private val _state = MutableStateFlow("Home State Loaded")
    val state: StateFlow<String> = _state
}