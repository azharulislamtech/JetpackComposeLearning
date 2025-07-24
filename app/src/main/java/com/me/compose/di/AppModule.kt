package com.me.compose.di


import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.viewmodel.NavDeepLinkViewModel
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.viewmodel.NavigationArgViewModel
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.viewmodel.HomeViewModel
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.viewmodel.ProfileViewModel
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.viewmodel.ScaffoldSetupViewModel
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.viewmodel.NavigationViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ScaffoldSetupViewModel() }
    viewModel { NavigationViewModel() }
    viewModel { NavigationArgViewModel() }
    viewModel { NavDeepLinkViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ProfileViewModel() }
}
