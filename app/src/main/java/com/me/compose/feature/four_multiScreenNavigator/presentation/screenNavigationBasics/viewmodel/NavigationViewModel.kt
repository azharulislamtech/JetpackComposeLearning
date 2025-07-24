package com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavigationViewModel: ViewModel() {
    val message = mutableStateOf("Hello from Home!")
}