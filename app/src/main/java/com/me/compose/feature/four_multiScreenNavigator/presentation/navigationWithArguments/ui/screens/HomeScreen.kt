package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen")
        Button(onClick = {
            navController.navigate(Screen.Profile.createRoute("1"))
        }) {
            Text("Go to Profile (User 1)")
        }
        Button(onClick = {
            navController.navigate(Screen.Profile.createRoute("invalid"))
        }) {
            Text("Go to Unknown Profile")
        }
    }
}
