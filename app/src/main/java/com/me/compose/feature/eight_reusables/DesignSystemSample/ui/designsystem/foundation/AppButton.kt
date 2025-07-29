package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppDimens
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppElevation

@Composable
fun AppButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(AppDimens.smallPadding),
        elevation = ButtonDefaults.buttonElevation(AppElevation.medium)
    ) {
        Text(text)
    }
}
