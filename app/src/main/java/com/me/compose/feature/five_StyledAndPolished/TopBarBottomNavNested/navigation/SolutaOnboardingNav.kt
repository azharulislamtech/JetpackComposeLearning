package com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.me.compose.R
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.screens.welcome.WelcomeScreen
import com.me.compose.feature.six_interactions.presentation.motiondemo.ui.screens.SplashScreen

@Composable
fun SolutaOnboardingNav(onFinished: () -> Unit) {
    val backStack = rememberNavBackStack<Onboarding>(Onboarding.Splash)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Onboarding.Splash> {
                SplashScreen { backStack.add(Onboarding.Welcome) }
            }
            entry<Onboarding.Welcome> {
                WelcomeScreen { backStack.add(Onboarding.Auth) }
            }
            entry<Onboarding.Auth> {
                AuthScreen { backStack.add(Onboarding.StoreSetup) }
            }
            entry<Onboarding.StoreSetup> {
                StoreSetupScreen { onFinished() }
            }
        }
    )
}

sealed class Onboarding : NavKey {
    data object Splash : Onboarding()
    data object Welcome : Onboarding()
    data object Auth : Onboarding()
    data object StoreSetup : Onboarding()
}

sealed class BottomBarScreen(val icon: Int) : NavKey {
    data object Home : BottomBarScreen(R.drawable.ic_360)
    data object Report : BottomBarScreen(R.drawable.pumpkin)
    data object Customer : BottomBarScreen(R.drawable.pumpkin)
}

