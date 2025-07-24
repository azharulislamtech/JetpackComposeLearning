package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.navigation.AppNavGraph

@Composable
fun NavDeepLinkScreen() {
    val navController = rememberNavController()
    AppNavGraph(navController)
}