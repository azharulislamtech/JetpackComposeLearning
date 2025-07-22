package com.me.compose.feature.two_layout_lab.domain

import com.me.compose.feature.two_layout_lab.data.model.CustomerProfile
import com.me.compose.feature.two_layout_lab.data.repository.CustomerProfileRepository

class GetCustomerProfileUseCase (private val repository: CustomerProfileRepository) {
    operator fun invoke(): List<CustomerProfile> = repository.getUsers()
}