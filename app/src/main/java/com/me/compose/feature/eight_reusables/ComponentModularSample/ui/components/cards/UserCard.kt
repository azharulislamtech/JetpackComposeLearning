package com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.modifiers.cardStyle
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.components.UserAvatar

/**
 * UserCard - A card displaying user avatar and basic info
 *
 * @param name Name of the user
 * @param email Email address
 */
@Composable
fun UserCard(name: String, email: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .cardStyle(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            UserAvatar(name,email)
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = name, style = MaterialTheme.typography.titleMedium)
                Text(text = email, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
fun PreviewUserCard() {
    UserCard(name = "Azharul Islam", email = "azharul@example.com")
}
