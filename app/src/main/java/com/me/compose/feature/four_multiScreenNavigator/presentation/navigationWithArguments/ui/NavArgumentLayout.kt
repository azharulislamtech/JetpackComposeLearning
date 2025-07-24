package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.navigation.AppNavGraph


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavArgumentLayout() {
    val navController = rememberAnimatedNavController()
    AppNavGraph(navController)
}