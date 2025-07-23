package com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.ui



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.ui.component.CustomTextFields
import com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.viewmodel.TextFieldViewModel


@Composable
fun TextFieldScreen(viewModel: TextFieldViewModel = viewModel()) {
    val name by viewModel.name.collectAsState()
    val description by viewModel.description.collectAsState()
    val isValid = viewModel.isFormValid()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CustomTextFields.NameInputField(
            value = name,
            onValueChange = viewModel::onNameChange,
            onClearClick = viewModel::clearName
        )

        CustomTextFields.DescriptionInputField(
            value = description,
            onValueChange = viewModel::onDescriptionChange,
            onClearClick = viewModel::clearDescription,
            remainingCount = viewModel.getRemainingChars()
        )

        Button(
            onClick = { /* Submit logic */ },
            enabled = isValid,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
