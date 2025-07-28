package com.me.compose.feature.five_StyledAndPolished.BasicThemApp.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val message by viewModel.uiState.collectAsState()
    Text(text = message)
}