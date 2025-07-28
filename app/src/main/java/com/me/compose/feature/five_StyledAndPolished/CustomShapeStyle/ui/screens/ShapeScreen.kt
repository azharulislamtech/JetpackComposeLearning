package com.me.compose.feature.five_StyledAndPolished.CustomShapeStyle.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.me.compose.feature.five_StyledAndPolished.CustomShapeStyle.ui.components.PillButton


@Composable
fun ShapeScreen(viewModel: ShapeViewModel = viewModel()) {
    val message by viewModel.message.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically)
    ) {
        // Surface container with medium cut corner shape
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 4.dp,
            shadowElevation = 6.dp,
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Text(
                text = message,
                modifier = Modifier.padding(24.dp),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        // Regular Button with rounded shape
        Button(
            onClick = { /* Do something */ },
            shape = MaterialTheme.shapes.large
        ) {
            Text("Rounded Button")
        }

        // Custom pill-shaped reusable component
        PillButton(text = "Pill Button") {
            // Action on click
        }
    }
}