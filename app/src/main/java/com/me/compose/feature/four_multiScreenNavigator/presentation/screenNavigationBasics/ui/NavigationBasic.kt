package com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation.AppNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationBasics() {
    val navController = rememberAnimatedNavController()
    AppNavGraph(navController = navController)
}