package com.me.compose.feature.six_interactions.presentation.sheetdrawerapp.ui.screens

import androidx.lifecycle.ViewModel
import com.me.compose.feature.six_interactions.data.model.FilterOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SheetDrawerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState

    init {
        _uiState.value = MainUiState(
            filterOptions = listOf(
                FilterOption("Newest"),
                FilterOption("Popular"),
                FilterOption("Recommended")
            )
        )
    }

    fun toggleSheet() {
        _uiState.update { it.copy(showBottomSheet = !it.showBottomSheet) }
    }

    fun toggleDrawer() {
        _uiState.update { it.copy(showDrawer = !it.showDrawer) }
    }

    fun selectFilter(index: Int) {
        _uiState.update {
            it.copy(
                filterOptions = it.filterOptions.mapIndexed { i, option ->
                    option.copy(isSelected = i == index)
                }
            )
        }
    }

    fun closeDrawer() {
        _uiState.update { it.copy(showDrawer = false) }
    }

    fun closeSheet() {
        _uiState.update { it.copy(showBottomSheet = false) }
    }
}

data class MainUiState(
    val filterOptions: List<FilterOption> = emptyList(),
    val showDrawer: Boolean = false,
    val showBottomSheet: Boolean = false
)