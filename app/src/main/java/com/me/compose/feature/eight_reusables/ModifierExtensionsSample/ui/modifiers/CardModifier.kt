package com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

inline fun Modifier.cardStyle(): Modifier = this
    .shadow(elevation = 4.dp, shape = RoundedCornerShape(12.dp))
    .padding(16.dp)