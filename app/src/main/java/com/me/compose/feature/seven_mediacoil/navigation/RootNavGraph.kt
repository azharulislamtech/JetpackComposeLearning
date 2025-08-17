package com.me.compose.feature.seven_mediacoil.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.me.compose.feature.seven_mediacoil.ui.DashboardScaffold

@Composable
fun SolutaRootGraph(navigateToSettings: () -> Unit) {
    val backStack = rememberNavBackStack<Route>(Route.Onboarding)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.Onboarding> {
                _root_ide_package_.com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation.SolutaOnboardingNav {
                    backStack.add(
                        Route.Dashboard
                    )
                }
            }
            entry<Route.Dashboard> {
                DashboardScaffold(navigateToSettings)
            }
        }
    )
}

sealed class Route : NavKey {
    data object Onboarding : Route()
    data object Dashboard : Route()
}
