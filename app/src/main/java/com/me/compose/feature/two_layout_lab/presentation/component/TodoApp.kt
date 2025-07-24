package com.me.compose.feature.two_layout_lab.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.two_layout_lab.presentation.TodoViewModel
import kotlinx.coroutines.launch


// Main Composable
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(viewModel: TodoViewModel = viewModel()) {
    val todoItems by viewModel.todoItems.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var newTodoText by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    var draggedItemIndex by remember { mutableStateOf<Int?>(null) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(title = { Text("Todo List") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Input field and button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = newTodoText,
                        onValueChange = { newTodoText = it },
                        modifier = Modifier.weight(1f),
                        label = { Text("New Todo") }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        viewModel.addTodo(newTodoText)
                        newTodoText = ""
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Todo added!")
                        }
                    }) {
                        Text("Add")
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Todo list with drag-to-reorder
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectDragGesturesAfterLongPress(
                                onDragStart = { offset ->
                                    val index = (offset.y / 80f).toInt()
                                    if (index in todoItems.indices) {
                                        draggedItemIndex = index
                                    }
                                },
                                onDragEnd = { draggedItemIndex = null },
                                onDragCancel = { draggedItemIndex = null },
                                onDrag = { change, dragAmount ->
                                    val targetIndex = (change.position.y / 80f).toInt()
                                    draggedItemIndex?.let { fromIndex ->
                                        if (targetIndex in todoItems.indices && fromIndex != targetIndex) {
                                            viewModel.reorderTodos(fromIndex, targetIndex)
                                            draggedItemIndex = targetIndex
                                        }
                                    }
                                }
                            )
                        }
                ) {
                    itemsIndexed(todoItems) { index, item ->
                        TodoItemRow(
                            item = item,
                            onToggle = { viewModel.toggleTodoCompletion(it) },
                            onDelete = { viewModel.deleteTodo(it) },
                            modifier = Modifier
                                .fillMaxWidth()
                              //  .animateItemPlacement()
                        )
                    }
                }
            }
        }
    )
}