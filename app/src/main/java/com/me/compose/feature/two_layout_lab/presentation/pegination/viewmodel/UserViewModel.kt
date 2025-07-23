package com.me.compose.feature.two_layout_lab.presentation.pegination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.compose.feature.two_layout_lab.presentation.pegination.data.model.User
import com.me.compose.feature.two_layout_lab.presentation.pegination.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// UserViewModel.kt
class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var currentPage = 1
    private val pageSize = 20
    private var endReached = false

    init {
        loadNextPage()
    }

    fun loadNextPage() {
        if (_isLoading.value || endReached) return
        viewModelScope.launch {
            _isLoading.value = true
            val newUsers = repository.fetchUsers(currentPage, pageSize)
            endReached = newUsers.isEmpty()
            _users.value = _users.value + newUsers
            currentPage++
            _isLoading.value = false
        }
    }
}
