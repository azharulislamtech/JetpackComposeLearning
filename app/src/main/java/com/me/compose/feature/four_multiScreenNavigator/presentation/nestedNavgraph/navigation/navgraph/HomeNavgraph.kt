package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.navgraph

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.NavigationActions
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.Routes
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.screens.home.DetailsScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.screens.home.HomeScreen

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeNavGraph(navActions: NavigationActions) {
    navigation(startDestination = Routes.HOME, route = Routes.HOME_ROOT) {
        composable(Routes.HOME) {
            HomeScreen(onDetailsClick = navActions::navigateToDetails,onProfileClick=navActions ::navigateToProfileRoot)
        }
        composable(Routes.DETAILS) {
            DetailsScreen(onBack = navActions::navigateUp)
        }
    }
}
