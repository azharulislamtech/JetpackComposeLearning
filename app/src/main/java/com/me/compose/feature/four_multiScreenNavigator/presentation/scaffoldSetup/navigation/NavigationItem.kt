package com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

val navItems = listOf(
    NavigationItem("home", Icons.Default.Home, "Home"),
    NavigationItem("profile", Icons.Default.Person, "Profile"),
    NavigationItem("settings", Icons.Default.Settings, "Settings")
)
