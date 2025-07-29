package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppDimens

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimens.smallPadding)
    )
}
