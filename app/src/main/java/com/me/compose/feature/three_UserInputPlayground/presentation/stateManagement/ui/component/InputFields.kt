package com.me.compose.feature.three_UserInputPlayground.presentation.stateManagement.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.VisibilityOff

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.*

object InputFields {

    @Composable
    fun NameField(
        value: String,
        onValueChange: (String) -> Unit,
        onFocusChanged: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Name") },
            placeholder = { Text("Enter your name") },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { onFocusChanged(it.isFocused) }
        )
    }

    @Composable
    fun PasswordField(
        value: String,
        onValueChange: (String) -> Unit,
        isVisible: Boolean,
        onToggleVisibility: () -> Unit,
        onFocusChanged: (Boolean) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text("Password") },
            placeholder = { Text("Enter password") },
            singleLine = true,
            visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val icon = if (isVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility
                val description = if (isVisible) "Hide Password" else "Show Password"
                IconButton(onClick = onToggleVisibility) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged { onFocusChanged(it.isFocused) }
        )
    }
}
