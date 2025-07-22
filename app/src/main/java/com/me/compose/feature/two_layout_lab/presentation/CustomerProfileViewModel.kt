package com.me.compose.feature.two_layout_lab.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.me.compose.feature.two_layout_lab.data.model.CustomerProfile
import com.me.compose.feature.two_layout_lab.data.repository.CustomerProfileRepository

class CustomerProfileViewModel (
    private val repository: CustomerProfileRepository
) : ViewModel() {

    private val _users = mutableStateListOf<CustomerProfile>()
    val users: List<CustomerProfile> get() = _users

    init {
        _users.addAll(repository.getUsers())
    }

    fun deleteUser(id: Int) {
        repository.deleteUser(id)
        _users.clear()
        _users.addAll(repository.getUsers())
    }

    fun moveUser(from: Int, to: Int) {
        repository.moveUser(from, to)
        _users.clear()
        _users.addAll(repository.getUsers())
    }
}