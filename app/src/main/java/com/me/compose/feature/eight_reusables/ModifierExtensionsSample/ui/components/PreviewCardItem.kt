package com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.screens.ModifierExtensionsScreen
import com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.theme.ModifierExtensionsSampleTheme

@Preview(showBackground = true)
@Composable
fun PreviewCardItem() {
    ModifierExtensionsSampleTheme {
        ModifierExtensionsScreen()
    }
}
