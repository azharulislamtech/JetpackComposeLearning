package com.me.compose.feature.two_layout_lab.presentation

import androidx.lifecycle.ViewModel
import com.me.compose.feature.two_layout_lab.data.model.TodoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID


// ViewModel
class TodoViewModel : ViewModel() {
    private val _todoItems = MutableStateFlow(listOf<TodoItem>())
    val todoItems: StateFlow<List<TodoItem>> = _todoItems.asStateFlow()

    fun addTodo(text: String) {
        if (text.isNotBlank()) {
            val newItem = TodoItem(id = UUID.randomUUID().toString(), text = text)
            _todoItems.value = _todoItems.value + newItem
        }
    }

    fun toggleTodoCompletion(item: TodoItem) {
        _todoItems.value = _todoItems.value.map {
            if (it.id == item.id) it.copy(isCompleted = !it.isCompleted) else it
        }
    }

    fun deleteTodo(item: TodoItem) {
        _todoItems.value = _todoItems.value.filter { it.id != item.id }
    }

    fun reorderTodos(fromIndex: Int, toIndex: Int) {
        val updatedList = _todoItems.value.toMutableList()
        val item = updatedList.removeAt(fromIndex)
        updatedList.add(toIndex, item)
        _todoItems.value = updatedList
    }
}