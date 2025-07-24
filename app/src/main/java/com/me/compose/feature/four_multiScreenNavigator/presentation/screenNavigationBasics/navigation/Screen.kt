package com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
}
