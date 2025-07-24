package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.viewmodel

import androidx.lifecycle.ViewModel

class NavigationArgViewModel: ViewModel() {

    fun getUserNameById(userId: String): String {
        return when (userId) {
            "1" -> "Azharul Islam"
            "2" -> "John Doe"
            else -> "Unknown User"
        }
    }

}