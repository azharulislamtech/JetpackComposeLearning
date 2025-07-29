package com.me.compose.feature.eight_reusables.ComponentModularSample.ui.components.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

inline fun Modifier.cardStyle(): Modifier = this
    .padding(8.dp)
    .shadow(4.dp, RoundedCornerShape(12.dp))
