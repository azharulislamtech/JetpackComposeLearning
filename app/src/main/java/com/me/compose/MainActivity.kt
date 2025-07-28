package com.me.compose

import CustomerListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.core.content.pm.ShortcutInfoCompat
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.me.compose.feature.five_StyledAndPolished.BasicThemApp.BasicThemApp
import com.me.compose.feature.five_StyledAndPolished.CustomShapeStyle.CustomShapeStyle
import com.me.compose.feature.five_StyledAndPolished.DarkModeApp.DarkModeAppTest
import com.me.compose.feature.five_StyledAndPolished.DynamicThemeApp.ui.screen.home.HomeScreen
import com.me.compose.feature.five_StyledAndPolished.TestTheme.TestTheme
import com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ThemePlaygroundRoute
import com.me.compose.feature.five_StyledAndPolished.TopBarBottomNavNested.ui.ThemeApp


import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationDeepLink.ui.NavDeepLinkScreen
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.NavArgumentLayout
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.NestedNavGraph
import com.me.compose.feature.four_multiScreenNavigator.presentation.scaffoldSetup.ui.components.ScaffoldLayout
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation.AppNavGraph
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.ui.NavigationBasics
import com.me.compose.feature.six_interactions.presentation.carddialogsnackbar.CarddialogsnackbarApp
import com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.ui.TextFieldApp
import com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.ui.TextFieldScreen
import com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.ui.InputScreen
import com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.ui.LoginScreen
import com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.SettingsScreen
import com.me.compose.feature.two_layout_lab.CreateLazyColumnRow
import com.me.compose.feature.two_layout_lab.presentation.DynamicDataScreen
import com.me.compose.feature.two_layout_lab.presentation.component.TodoApp
import com.me.compose.feature.two_layout_lab.presentation.view.ProductScreen
import com.me.compose.ui.theme.JetpackComposeLearningTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearningTheme {

//                CreateText("Azharul Islam")
//                CreateButton()
//                CreateImage()
//                CreateSpacer()
//                CreateSurface()
//                CreateModifier()
//                CreateColumn()
//                CreateRow()
//                CreateBox()
//                CreateMixedLayout()
//                CreateLazyColumnRow()
//                DynamicDataScreen()
//                TodoApp()
//                CustomerListScreen()
//                TextFieldApp()
//                InputScreen()
//                SettingsScreen()
//                LoginScreen()
//                ScaffoldLayout()
//                NavigationBasics()
//                NavArgumentLayout()
//                NavDeepLinkScreen()
//                NestedNavGraph()
//                ThemeApp()
//                BasicThemApp()
//                HomeScreen()
//                TestTheme()
//                CustomShapeStyle()
//                DarkModeAppTest()
//                ThemePlaygroundRoute()
                CarddialogsnackbarApp()
            }
        }
    }

}


