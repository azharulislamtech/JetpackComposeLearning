package com.me.compose.feature.five_StyledAndPolished.TestTheme.ui.screens

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.me.compose.feature.five_StyledAndPolished.TestTheme.ui.theme.ThemeTestingAppTheme

@Composable
fun ThemeScreen(
    currentThemePreference: Boolean?, // Null for system, true for light, false for dark
    onToggleTheme: (Boolean?) -> Unit // Callback to update preference
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Display current theme status
        Text(
            text = when (currentThemePreference) {
                true -> "Current Theme: Light (User Override)"
                false -> "Current Theme: Dark (User Override)"
                else -> "Current Theme: System Default (${if (androidx.compose.foundation.isSystemInDarkTheme()) "Dark" else "Light"})"
            },
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Toggle Switch for Theme
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Force Light Theme",
                color = MaterialTheme.colorScheme.onSurface
            )
            Switch(
                checked = currentThemePreference == true, // Checked if explicitly light
                onCheckedChange = { isChecked ->
                    onToggleTheme(if (isChecked) true else null) // Set to light or null (system)
                }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Force Dark Theme",
                color = MaterialTheme.colorScheme.onSurface
            )
            Switch(
                checked = currentThemePreference == false, // Checked if explicitly dark
                onCheckedChange = { isChecked ->
                    onToggleTheme(if (isChecked) false else null) // Set to dark or null (system)
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Example UI elements to show theme changes
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "This is a Card",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Do something */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            )
        ) {
            Text("Themed Button")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This text color changes with the theme.",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Preview in light theme
    ThemeTestingAppTheme(darkTheme = false) {
        ThemeScreen(currentThemePreference = true, onToggleTheme = {})
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    // Preview in dark theme
    ThemeTestingAppTheme(darkTheme = true) {
        ThemeScreen(currentThemePreference = false, onToggleTheme = {})
    }
}