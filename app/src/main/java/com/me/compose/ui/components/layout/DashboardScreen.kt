package com.me.compose.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScreen(
    userName: String,
    stats: List<String>,
    actionLabels: List<String>,
    onActionClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))  // Light background
            .padding(16.dp)
    ) {
        // Header: Box with centered welcome text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome, $userName!",
                style = MaterialTheme.typography.headlineMedium.copy(color = Color.White)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Content: Column with stats
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Your Stats",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            stats.forEach { stat ->
                Text(
                    text = stat,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Actions: Row with buttons spaced evenly
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            actionLabels.forEach { label ->
                Button(
                    onClick = { onActionClick(label) },
                    modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
                ) {
                    Text(text = label)
                }
            }
        }
    }
}
