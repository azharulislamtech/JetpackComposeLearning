package com.me.compose.feature.three_UserInputPlayground.presentation.stateAndInput.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TextFieldViewModel : ViewModel() {

    private val maxDescriptionLength = 200

    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name

    private val _description = MutableStateFlow("")
    val description: StateFlow<String> = _description

    fun onNameChange(newName: String) {
        _name.value = newName
    }

    fun onDescriptionChange(newDesc: String) {
        if (newDesc.length <= maxDescriptionLength) {
            _description.value = newDesc
        }
    }

    fun clearName() = onNameChange("")
    fun clearDescription() = onDescriptionChange("")

    fun isFormValid(): Boolean {
        return _name.value.isNotBlank() && _description.value.isNotBlank()
    }

    fun getRemainingChars(): Int {
        return maxDescriptionLength - _description.value.length
    }
}
