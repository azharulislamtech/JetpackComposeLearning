package com.me.compose.feature.two_layout_lab.domain

import com.me.compose.feature.two_layout_lab.data.model.UserProfile
import com.me.compose.feature.two_layout_lab.data.repository.UserProfileRepository

class GetUserProfilesUseCase(private val repository: UserProfileRepository) {
    suspend operator fun invoke(): List<UserProfile> = repository.getUserProfiles()
}