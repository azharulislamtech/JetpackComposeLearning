package com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.ui.screens.HomeScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.ui.screens.ProfileScreen
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.SettingsScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}


