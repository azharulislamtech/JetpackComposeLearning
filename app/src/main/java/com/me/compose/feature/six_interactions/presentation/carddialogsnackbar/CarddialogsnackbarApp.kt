package com.me.compose.feature.six_interactions.presentation.carddialogsnackbar

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.me.compose.feature.six_interactions.presentation.carddialogsnackbar.ui.screens.CarddialogsnackbarScreen
import com.me.compose.feature.six_interactions.presentation.carddialogsnackbar.ui.screens.CarddialogsnackbarViewModel
import com.me.compose.feature.six_interactions.presentation.carddialogsnackbar.ui.theme.CardDialogSnackbarTheme

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun CarddialogsnackbarApp(){
    CardDialogSnackbarTheme {
        CarddialogsnackbarScreen(viewModel = CarddialogsnackbarViewModel())
    }
}