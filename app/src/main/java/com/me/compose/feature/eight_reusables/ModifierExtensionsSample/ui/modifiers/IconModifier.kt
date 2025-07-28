package com.me.compose.feature.eight_reusables.ModifierExtensionsSample.ui.modifiers

import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

inline fun Modifier.iconSize(): Modifier = this.size(24.dp)