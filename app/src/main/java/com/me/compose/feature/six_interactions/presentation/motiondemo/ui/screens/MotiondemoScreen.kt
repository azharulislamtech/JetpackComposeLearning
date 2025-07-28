package com.me.compose.feature.six_interactions.presentation.motiondemo.ui.screens

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun MotiondemoScreen(viewModel: MotiondemoViewModel) {
    val isLoading by viewModel.isLoading.collectAsState()

    if (isLoading) {
        ShimmerPlaceholder()
        LaunchedEffect(Unit) {
            delay(3000) // simulate loading
            viewModel.stopLoading()
        }
    } else {
        AnimatedUIContent()
    }
}

@Composable
fun ShimmerPlaceholder() {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val xShimmer by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "xShimmer"
    )

    val brush = Brush.linearGradient(
        colors = listOf(Color.Gray, Color.LightGray, Color.Gray),
        start = Offset(xShimmer, xShimmer),
        end = Offset(xShimmer + 200f, xShimmer + 200f)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        repeat(3) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(8.dp)
                    .background(brush, shape = MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
fun AnimatedUIContent() {
    val infiniteTransition = rememberInfiniteTransition(label = "backgroundCycle")

    val bgColor by infiniteTransition.animateColor(
        initialValue = Color(0xFF4CAF50),
        targetValue = Color(0xFFFF5722),
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bgColor"
    )

    val pulse by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Animated Background + Pulse Avatar", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .scale(pulse)
                .background(Color.White, shape = CircleShape)
        )

        Spacer(modifier = Modifier.height(24.dp))

        BreathingButton()
    }
}

@Composable
fun BreathingButton() {
    val transition = rememberInfiniteTransition(label = "breath")
    val scale by transition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "breathingScale"
    )

    Button(
        onClick = {},
        modifier = Modifier
            .scale(scale)
            .padding(8.dp)
    ) {
        Text("Breathing Action")
    }
}