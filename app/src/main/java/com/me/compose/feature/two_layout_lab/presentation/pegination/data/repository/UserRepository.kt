package com.me.compose.feature.two_layout_lab.presentation.pegination.data.repository

import com.me.compose.feature.two_layout_lab.presentation.pegination.data.model.User
import com.me.compose.feature.two_layout_lab.presentation.pegination.data.remote.ApiService

// UserRepository.kt
class UserRepository(private val api: ApiService) {
    suspend fun fetchUsers(page: Int, pageSize: Int): List<User> {
        return api.getUsers(page, pageSize)
    }
}
