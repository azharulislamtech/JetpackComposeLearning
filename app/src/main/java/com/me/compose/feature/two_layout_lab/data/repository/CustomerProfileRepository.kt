package com.me.compose.feature.two_layout_lab.data.repository

import androidx.compose.runtime.mutableStateListOf
import com.me.compose.feature.two_layout_lab.data.model.CustomerProfile

class CustomerProfileRepository {

    private val userList = mutableStateListOf(
        CustomerProfile(1, "Alice"),
        CustomerProfile(2, "Bob"),
        CustomerProfile(3, "Charlie")
    )

    fun getUsers(): List<CustomerProfile> = userList

    fun deleteUser(id: Int) {
        userList.removeIf { it.id == id }
    }

    fun moveUser(from: Int, to: Int) {
        userList.add(to, userList.removeAt(from))
    }
}