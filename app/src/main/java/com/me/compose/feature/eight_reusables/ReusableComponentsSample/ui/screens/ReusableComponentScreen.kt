package com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.components.AppButton
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.components.IconTextRow
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.components.UserAvatar

@Composable
fun ReusableComponentsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        UserAvatar(
            imageUrl = "https://i.pravatar.cc/150?img=10",
            name = "Jane Doe",
            role = "UI Designer"
        )
        IconTextRow(icon = Icons.Default.Phone, text = "+8801717121839")
        AppButton(label = "Contact", icon = Icons.Default.Phone) {
            // handle click
        }
    }
}
