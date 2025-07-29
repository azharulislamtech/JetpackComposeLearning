package com.me.compose.feature.eight_reusables.ComponentModularSample.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.ComponentModularSample.ui.base.SectionTitle
import com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.cards.UserCard
import com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.toolbars.ActionToolbar
import com.me.compose.feature.eight_reusables.ReusableComponentsSample.ui.components.AppButton
import com.me.compose.ui.components.spacer.VerticalSpacer

@Composable
fun ComponentModularScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        ActionToolbar(title = "Contacts") { /* Handle Add */ }

        VerticalSpacer()

        SectionTitle("My Team")

        UserCard(name = "Jane Doe", email = "jane@company.com")
        UserCard(name = "Azharul Islam", email = "azharul@example.com")

        VerticalSpacer()

        AppButton(label = "See All") { /* Handle Click */ }
    }
}
