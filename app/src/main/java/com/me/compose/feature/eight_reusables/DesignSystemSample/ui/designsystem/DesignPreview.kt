package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation.AppButton
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation.AppCard
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation.AppTextField
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppDimens

@Composable
fun DesignPreviewScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppDimens.defaultPadding),
        verticalArrangement = Arrangement.spacedBy(AppDimens.smallPadding)
    ) {
        Text("Design System Tokens", style = MaterialTheme.typography.titleLarge)

        AppButton(text = "Primary Action") {}
        AppCard {
            Text("This is a card")
        }
        AppTextField(value = "", onValueChange = {}, label = "Your Name")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDesignSystem() {
    DesignSystemSampleTheme {
        DesignPreviewScreen()
    }
}
