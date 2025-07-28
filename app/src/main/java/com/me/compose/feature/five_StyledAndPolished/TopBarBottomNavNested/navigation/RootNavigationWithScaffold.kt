package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.Screen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.auth.LoginScreen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.auth.RegisterScreen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.welcome.WelcomeScreen


@Composable
fun RootNavigationWithScaffold() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WELCOME
    ) {
        composable(Routes.WELCOME) {
            WelcomeScreen(
                onLoginClick = { navController.navigate(Routes.LOGIN) },
                onRegisterClick = { navController.navigate(Routes.REGISTER) }
            )
        }
        composable(Routes.LOGIN) {
            LoginScreen(onLoginSuccess = {
                navController.navigate(Routes.MAIN) {
                    popUpTo(0) { inclusive = true }
                }
            })
        }
        composable(Routes.REGISTER) {
            RegisterScreen(onRegisterSuccess = {
                navController.navigate(Routes.MAIN) {
                    popUpTo(0) { inclusive = true }
                }
            })
        }

        navigation(startDestination = Screen.Home.route, route = Routes.MAIN) {
            composable(Screen.Home.route) {
                ScaffoldLayout(navController = navController, selectedScreen = Screen.Home)
            }
            composable(Screen.Profile.route) {
                ScaffoldLayout(navController = navController, selectedScreen = Screen.Profile)
            }
        }
    }
}


