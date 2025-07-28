package com.me.compose.feature.five_StyledAndPolished.ThemePlayground.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ThemePlaygroundScreen(viewModel: ThemePlayGroundViewmodel = viewModel()) {
    val message by viewModel.message.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = message, style = MaterialTheme.typography.headlineLarge)
        Spacer(Modifier.height(16.dp))
        Button(onClick = {}) {
            Text("Explore Styles")
        }
    }
}