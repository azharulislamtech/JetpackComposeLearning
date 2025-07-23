package com.me.compose.feature.two_layout_lab.presentation.pegination.data.remote

import com.me.compose.feature.two_layout_lab.presentation.pegination.data.model.User
import kotlinx.coroutines.delay

// ApiService.kt
class ApiService {
    suspend fun getUsers(page: Int, pageSize: Int): List<User> {
        delay(1000) // simulate network
        val startId = (page - 1) * pageSize
        return (startId until startId + pageSize).map {
            User(id = it, name = "User $it", avatarUrl = "")
        }
    }
}
