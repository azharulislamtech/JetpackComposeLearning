package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.navgraph.homeNavGraph
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.navgraph.profileNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
    val navActions = remember(navController) { NavigationActions(navController) }

    NavHost(navController = navController, startDestination = Routes.HOME_ROOT) {
        homeNavGraph(navActions)
        profileNavGraph(navActions)
    }
}
