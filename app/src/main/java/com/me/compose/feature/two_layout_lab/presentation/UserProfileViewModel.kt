package com.me.compose.feature.two_layout_lab.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.compose.feature.two_layout_lab.data.model.UserProfile
import com.me.compose.feature.two_layout_lab.domain.GetUserProfilesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val getUserProfilesUseCase: GetUserProfilesUseCase
) : ViewModel() {

    private val _userProfiles = MutableStateFlow<List<UserProfile>>(emptyList())
    val userProfiles: StateFlow<List<UserProfile>> = _userProfiles

    init {
        fetchUserProfiles()
    }

    private fun fetchUserProfiles() {
        viewModelScope.launch {
            _userProfiles.value = getUserProfilesUseCase()
        }
    }
}