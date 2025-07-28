package com.me.compose.feature.five_StyledAndPolished.CustomShapeStyle.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ShapeViewModel : ViewModel() {
    private val _message = MutableStateFlow("Explore Custom Shapes")
    val message = _message.asStateFlow()
}