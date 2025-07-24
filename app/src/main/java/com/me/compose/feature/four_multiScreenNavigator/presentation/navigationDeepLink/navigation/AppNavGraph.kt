package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.google.accompanist.navigation.animation.composable
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.ui.screens.HomeScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.ui.screens.ProfileScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.ui.screens.Screen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }


        composable(
            route = Screen.Profile.route,
            arguments = listOf(navArgument("userId") { type = NavType.StringType }),
            deepLinks = listOf(navDeepLink {
                uriPattern = Screen.Profile.deepLinkPattern
            })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")
            ProfileScreen(userId)
        }
    }
}
