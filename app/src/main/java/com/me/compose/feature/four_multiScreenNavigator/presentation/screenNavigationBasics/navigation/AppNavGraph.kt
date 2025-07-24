package com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.ui.screens.HomeScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.ui.screens.ProfileScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}
