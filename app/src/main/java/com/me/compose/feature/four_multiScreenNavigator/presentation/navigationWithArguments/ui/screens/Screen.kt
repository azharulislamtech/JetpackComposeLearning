package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.screens

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile/{userId}") {
        fun createRoute(userId: String) = "profile/$userId"
    }
}
