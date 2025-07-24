package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.RootNavGraph

@Composable
fun NestedNavGraph() {
    val navController = rememberNavController()
    RootNavGraph(navController = navController)
}