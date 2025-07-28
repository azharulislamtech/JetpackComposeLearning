package com.me.compose.feature.five_StyledAndPolished.CustomShapeStyle.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(12.dp),
    large = RoundedCornerShape(28.dp) // for pill/chip
)