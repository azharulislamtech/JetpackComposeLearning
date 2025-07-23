package com.me.compose.feature.two_layout_lab.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.me.compose.feature.two_layout_lab.data.model.CustomerProfile
import com.me.compose.feature.two_layout_lab.data.repository.CustomerProfileRepository
import com.me.compose.feature.two_layout_lab.domain.GetCustomerProfileUseCase

class CustomerProfileViewModel (
    private val getUsers: GetCustomerProfileUseCase,
) : ViewModel() {
    private val repository= CustomerProfileRepository()

    private val _users = mutableStateListOf<CustomerProfile>()
    val users: List<CustomerProfile> get() = _users

    init {
        _users.addAll(getUsers())
    }

    fun deleteUser(id: Int) {
        repository.deleteUser(id)
        _users.clear()
        _users.addAll(getUsers())
    }

    fun moveUser(from: Int, to: Int) {
        repository.moveUser(from, to)
        _users.clear()
        _users.addAll(getUsers())
    }
}