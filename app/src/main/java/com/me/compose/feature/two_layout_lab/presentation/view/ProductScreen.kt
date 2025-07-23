package com.me.compose.feature.two_layout_lab.presentation.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.two_layout_lab.presentation.viewmodel.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel = viewModel()) {
    val categories by viewModel.categories.collectAsState()
    val isLoading by viewModel.loading.collectAsState()

    if (isLoading) {
        LoadingShimmer()
    } else {
        LazyColumn {
            itemsIndexed(categories) { index, category ->
                CategoryCard(category, isEven = index % 2 == 0)
            }
        }
    }
}
