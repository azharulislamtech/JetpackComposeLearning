package com.me.compose.feature.two_layout_lab.data.repository

import com.me.compose.R
import com.me.compose.feature.two_layout_lab.data.model.UserProfile
import kotlinx.coroutines.delay

class UserProfileRepository {

    suspend fun getUserProfiles(): List<UserProfile> {
        // Simulate network delay
        delay(1000)

        return listOf(
            UserProfile(1, "Azharul Islam", "azhar@example.com", R.drawable.pumpkin),
            UserProfile(2, "John Doe", "john@example.com", R.drawable.pumpkin),
            UserProfile(3, "Jane Smith", "jane@example.com", R.drawable.pumpkin),
            UserProfile(4, "Michael Scott", "michael@dundermifflin.com", R.drawable.pumpkin),
            UserProfile(5, "Dwight Schrute", "dwight@beets.com", R.drawable.pumpkin)
        )
    }
}