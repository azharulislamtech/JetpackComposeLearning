package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {

    private val _userName = MutableStateFlow("Azharul Islam")
    val userName: StateFlow<String> = _userName

    fun updateName(newName: String) {
        _userName.value = newName
    }
}
