package com.me.compose.feature.two_layout_lab.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.me.compose.feature.two_layout_lab.data.model.Category
import com.me.compose.feature.two_layout_lab.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ProductViewModel.kt
class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    init {
        viewModelScope.launch {
            _loading.value = true
            _categories.value = repository.fetchCategories()
            _loading.value = false
        }
    }
}