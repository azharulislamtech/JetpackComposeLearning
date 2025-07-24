package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.viewmodel

import androidx.lifecycle.ViewModel

class NavDeepLinkViewModel: ViewModel() {
    fun getUserById(id: String): String {
        return when (id) {
            "1" -> "Azharul Islam"
            "2" -> "John Doe"
            else -> "Unknown User"
        }
    }
}