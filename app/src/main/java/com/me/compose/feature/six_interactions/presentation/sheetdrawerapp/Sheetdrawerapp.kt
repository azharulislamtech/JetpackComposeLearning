package com.me.compose.feature.six_interactions.presentation.sheetdrawerapp

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.me.compose.feature.six_interactions.presentation.sheetdrawerapp.ui.screens.SheetDrawerScreen
import com.me.compose.feature.six_interactions.presentation.sheetdrawerapp.ui.screens.SheetDrawerViewModel
import com.me.compose.feature.six_interactions.presentation.sheetdrawerapp.ui.them.SheetDrawerAppTheme

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun Sheetdrawerapp(){

    SheetDrawerAppTheme {
        SheetDrawerScreen(viewModel = SheetDrawerViewModel())
    }
}