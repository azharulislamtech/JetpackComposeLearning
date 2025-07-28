package com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ThemePlayGroundViewmodel  : ViewModel() {
    private val _message = MutableStateFlow("Welcome to Theme Playground!")
    val message = _message.asStateFlow()
}