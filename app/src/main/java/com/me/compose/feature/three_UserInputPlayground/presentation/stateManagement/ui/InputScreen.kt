package com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.ui



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.ui.component.InputFields
import com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.viewmodel.InputViewModel

@Composable
fun InputScreen(viewModel: InputViewModel = viewModel()) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        InputFields.NameField(
            value = state.name,
            onValueChange = viewModel::onNameChange,
            onFocusChanged = viewModel::onNameFocusChanged
        )

        Text("Live Preview: ${state.name}")
        if (state.isNameFocused) {
            Text("🟢 Name field is focused", color = MaterialTheme.colorScheme.primary)
        }

        InputFields.PasswordField(
            value = state.password,
            onValueChange = viewModel::onPasswordChange,
            isVisible = state.isPasswordVisible,
            onToggleVisibility = viewModel::onPasswordVisibilityToggle,
            onFocusChanged = viewModel::onPasswordFocusChanged
        )

        if (state.isPasswordFocused) {
            Text("🔒 Password field is focused", color = MaterialTheme.colorScheme.primary)
        }

        Button(
            onClick = { /* Submit action */ },
            enabled = state.isFormValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
