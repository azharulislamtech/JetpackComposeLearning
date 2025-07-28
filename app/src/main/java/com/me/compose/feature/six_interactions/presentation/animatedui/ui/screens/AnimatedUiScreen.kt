package com.me.compose.feature.six_interactions.presentation.animatedui.ui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.me.compose.feature.six_interactions.data.model.ViewMode

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedUIScreen(viewModel: AnimatedUiViewModel) {
    val state by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { viewModel.toggleInfoVisibility() }) {
                Icon(Icons.Default.Info, contentDescription = "Toggle Info")
            }
            IconButton(onClick = { viewModel.toggleViewMode() }) {
                Icon(
                    if (state.viewMode == ViewMode.LIST) Icons.Default.GridView else Icons.Default.List,
                    contentDescription = "Toggle View"
                )
            }
        }

        AnimatedVisibility(
            visible = state.showInfo,
            enter = fadeIn(animationSpec = tween(500)) + slideInVertically(initialOffsetY = { -50 }),
            exit = fadeOut(animationSpec = tween(300)) + slideOutVertically(targetOffsetY = { -50 })
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Welcome!", style = MaterialTheme.typography.titleMedium)
                    Text("Toggle the card or switch view mode below.")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Crossfade(targetState = state.viewMode, label = "viewSwitcher") { mode ->
            when (mode) {
                ViewMode.LIST -> ItemListView()
                ViewMode.GRID -> ItemGridView()
            }
        }
    }
}

@Composable
fun ItemListView() {
    LazyColumn {
        items(10) {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)) {
                ListItem(
                    headlineContent = { Text("Item #$it") },
                    supportingContent = { Text("List View Item") }
                )
            }
        }
    }
}

@Composable
fun ItemGridView() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(4.dp)) {
        items(10) {
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Item #$it")
                    Text("Grid View", style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}
