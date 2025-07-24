package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.screens.HomeScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.screens.ProfileScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation.Screen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = "profile/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            ProfileScreen(userId)
        }

    }
}
