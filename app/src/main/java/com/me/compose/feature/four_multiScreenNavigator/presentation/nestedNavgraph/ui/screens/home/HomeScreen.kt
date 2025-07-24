package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onDetailsClick: () -> Unit,
    onProfileClick: () -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    val scrollState = rememberLazyListState(viewModel.scrollPosition)

    LaunchedEffect(scrollState.firstVisibleItemIndex) {
        viewModel.scrollPosition = scrollState.firstVisibleItemIndex
    }

    Column {
        TextField(
            value = viewModel.inputText,
            onValueChange = { viewModel.inputText = it },
            label = { Text("Name") }
        )
        LazyColumn(state = scrollState) {
            items(10) { Text("Item #$it") }
        }
        Button(onClick = onDetailsClick) {
            Text("Go to Details")
        }
        Button(onClick = onProfileClick) {
            Text("Go to Profile")
        }
    }
}
