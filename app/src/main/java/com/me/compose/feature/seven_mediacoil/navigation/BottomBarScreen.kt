package com.me.compose.feature.seven_mediacoil.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey

sealed class BottomBarScreen(val icon: ImageVector, val label: String) : NavKey {
    data object Home : BottomBarScreen(Icons.Default.Home, "Home")
    data object Report : BottomBarScreen(Icons.Default.Analytics, "Report")
    data object Customer : BottomBarScreen(Icons.Default.Person, "Customer")
}
