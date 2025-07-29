package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.buttons.AppButton
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation.AppButton
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation.AppCard
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppDimens

@Composable
fun DesignSystemScreen() {
    Column(Modifier.fillMaxSize().padding(AppDimens.defaultPadding)) {
        AppCard {
            Text("Welcome Azharul", style = MaterialTheme.typography.titleMedium)
        }
        AppButton(text = "Get Started") {
            // handle click
        }
    }
}
