package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.Screen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.home.HomeScreen
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.profile.ProfileScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLayout(
    navController: NavHostController,
    selectedScreen: Screen
) {
    val items = listOf(Screen.Home, Screen.Profile)

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(selectedScreen.label) })
        },
        bottomBar = {
            NavigationBar {
                items.forEach { screen ->
                    NavigationBarItem(
                        selected = screen == selectedScreen,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(Routes.MAIN) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (selectedScreen) {
                Screen.Home -> HomeScreen()
                Screen.Profile -> ProfileScreen()
            }
        }
    }
}

