package com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.components.CardItem


@Composable
fun ModifierExtensionsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CardItem(title = "Azharul Islam", subtitle = "Senior Android Dev") {
            // Handle click
        }
        CardItem(title = "Jane Doe", subtitle = "UI/UX Designer") {
            // Handle click
        }
    }
}