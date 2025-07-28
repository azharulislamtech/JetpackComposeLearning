package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.auth.LoginScreen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.auth.RegisterScreen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.welcome.WelcomeScreen


import com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.ui.LoginScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.WELCOME) {
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

     /*   navigation(startDestination = Routes.HOME, route = Routes.MAIN) {
            composable(Routes.HOME) { HomeScreen() }
            composable(Routes.PROFILE) { ProfileScreen() }
        }*/
    }
}
