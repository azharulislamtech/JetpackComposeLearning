package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel: ViewModel() {
    private val _username = MutableStateFlow("Azharul")
    val username: StateFlow<String> = _username
}