package com.me.compose.feature.four_multiScreenNavigator.presentation.nestedNavgraph.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var scrollPosition by mutableStateOf(0)
    var inputText by mutableStateOf("")
}
