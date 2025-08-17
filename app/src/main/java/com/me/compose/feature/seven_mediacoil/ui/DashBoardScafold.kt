package com.me.compose.feature.seven_mediacoil.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation3.runtime.rememberNavBackStack
import com.me.compose.R
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation.BottomBarScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScaffold(navigateToSettings: () -> Unit) {
    val backStack = rememberNavBackStack<BottomBarScreen>(BottomBarScreen.Home)
    var currentScreen by rememberSaveable(stateSaver = BottomBarScreenSaver) {
        mutableStateOf(BottomBarScreen.Home)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Soluta Dashboard") },
                actions = {
                    IconButton(onClick = navigateToSettings) {
                        Icon(painterResource(R.drawable.ic_360), contentDescription = "Settings")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomBarItems.forEach { screen ->
                    NavigationBarItem(
                        selected = screen == currentScreen,
                        icon = { Icon(painterResource(screen.icon), contentDescription = null) },
                        onClick = {
                            if (backStack.lastOrNull() != screen) {
                                if (backStack.lastOrNull() in bottomBarItems) {
                                    backStack.removeLastOrNull()
                                }
                                backStack.add(screen)
                                currentScreen = screen
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<BottomBarScreen.Home> { HomeScreen() }
                entry<BottomBarScreen.Report> { ReportScreen() }
                entry<BottomBarScreen.Customer> { CustomerScreen() }
            }
        )
    }
}
