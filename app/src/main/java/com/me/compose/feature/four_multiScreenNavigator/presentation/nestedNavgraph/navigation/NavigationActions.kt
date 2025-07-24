package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation

import androidx.navigation.NavHostController

class NavigationActions(private val navController: NavHostController) {
    fun navigateToDetails() = navController.navigate(Routes.DETAILS)
    fun navigateToProfileRoot() = navController.navigate(Routes.PROFILE_ROOT)
    fun navigateToEditProfile() = navController.navigate(Routes.EDIT_PROFILE)
    fun goBack() = navController.popBackStack()
    fun navigateUp() = navController.navigateUp()
}
