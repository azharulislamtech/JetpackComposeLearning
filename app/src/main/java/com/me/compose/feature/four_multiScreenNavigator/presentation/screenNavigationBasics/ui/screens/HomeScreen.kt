package com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.navigation.Screen
import com.me.compose.feature.four_multiScreenNavigator.presentation.screenNavigationBasics.viewmodel.NavigationViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: NavigationViewModel = koinViewModel()
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(viewModel.message.value)
        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(Screen.Profile.route)
        }) {
            Text("Go to Profile")
        }
    }
}
