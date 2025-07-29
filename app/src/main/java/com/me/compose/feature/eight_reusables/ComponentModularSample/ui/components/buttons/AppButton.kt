package com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * AppButton - A unified primary button with consistent style
 *
 * @param label Button text
 * @param icon Optional icon (start)
 * @param onClick Click listener
 */
@Composable
fun AppButton(
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        icon?.let {
            Icon(imageVector = it, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(label)
    }
}

@Preview
@Composable
fun PreviewAppButton() {
    AppButton(label = "Continue", icon = Icons.Default.ArrowForward, onClick = {})
}
