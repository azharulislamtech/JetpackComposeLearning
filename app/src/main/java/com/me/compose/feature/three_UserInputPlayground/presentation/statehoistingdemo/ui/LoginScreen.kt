package com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.ui.components.HoistedTextField
import com.me.compose.feature.three_UserInputPlayground.presentation.statehoistingdemo.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        HoistedTextField(
            label = "Email",
            value = state.email,
            onValueChange = viewModel::onEmailChange
        )

        Spacer(modifier = Modifier.height(16.dp))

        HoistedTextField(
            label = "Password",
            value = state.password,
            onValueChange = viewModel::onPasswordChange,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = viewModel::submit,
            enabled = state.isFormValid
        ) {
            Text("Submit")
        }
    }
}
