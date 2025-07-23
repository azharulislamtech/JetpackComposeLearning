package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ToggleControls(
    isEnabled: Boolean,
    onToggle: (Boolean) -> Unit,
    isChecked: Boolean,
    onCheck: (Boolean) -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Enable Setting")
            Spacer(Modifier.weight(1f))
            Switch(checked = isEnabled, onCheckedChange = onToggle)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = isChecked, onCheckedChange = onCheck)
            Spacer(Modifier.width(8.dp))
            Text("I agree to terms")
        }
    }
}
