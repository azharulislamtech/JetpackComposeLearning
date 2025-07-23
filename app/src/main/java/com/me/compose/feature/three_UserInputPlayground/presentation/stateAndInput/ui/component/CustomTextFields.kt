package com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.ui.component



import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

object CustomTextFields {

    @Composable
    fun NameInputField(
        value: String,
        onValueChange: (String) -> Unit,
        onClearClick: () -> Unit
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Name") },
            placeholder = { Text("Enter your name") },
            trailingIcon = {
                if (value.isNotEmpty()) {
                    IconButton(onClick = onClearClick) {
                        Icon(Icons.Default.Clear, contentDescription = "Clear Name")
                    }
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun DescriptionInputField(
        value: String,
        onValueChange: (String) -> Unit,
        onClearClick: () -> Unit,
        remainingCount: Int
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text("Description") },
                placeholder = { Text("Write something...") },
                trailingIcon = {
                    if (value.isNotEmpty()) {
                        IconButton(onClick = onClearClick) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear Description")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 5
            )
            Text(
                text = "Remaining characters: $remainingCount",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .align(Alignment.End)
            )
        }
    }
}
