package com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.four_multiScreenNavigator.presentation.navigationWithArguments.viewmodel.NavigationArgViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProfileScreen(userId: String?, viewModel: NavigationArgViewModel = koinViewModel()) {
    val userName = remember(userId) {
        userId?.let { viewModel.getUserNameById(it) } ?: "Missing User ID"
    }

    Box(
        Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("User ID: $userId\nName: $userName")
    }
}
