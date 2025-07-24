package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.NavigationActions
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.navigation.Routes
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.screens.profile.EditProfileScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.screens.profile.ProfileScreen

fun NavGraphBuilder.profileNavGraph(navActions: NavigationActions) {
    navigation(startDestination = Routes.PROFILE, route = Routes.PROFILE_ROOT) {
        composable(Routes.PROFILE) {
            ProfileScreen(onEditClick = navActions::navigateToEditProfile)
        }
        composable(Routes.EDIT_PROFILE) {
            EditProfileScreen(onBack = navActions::goBack)
        }
    }
}
