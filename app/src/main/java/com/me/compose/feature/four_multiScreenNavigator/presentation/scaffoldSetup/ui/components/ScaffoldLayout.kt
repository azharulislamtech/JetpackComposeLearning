package com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.navigation.AppNavHost
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.navigation.navItems
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.viewmodel.ScaffoldSetupViewModel
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldLayout(viewModel: ScaffoldSetupViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val currentDestination by navController.currentBackStackEntryAsState()
    val currentRoute = currentDestination?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MyApp") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back or settings */ }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                navItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Handle FAB action */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    )
    { padding ->
        AppNavHost(navController = navController, modifier = Modifier.padding(padding))
    }
}
