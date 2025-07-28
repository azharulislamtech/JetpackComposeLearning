package com.me.compose.feature.six_interactions.presentation.sheetdrawerapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.six_interactions.data.model.FilterOption

import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SheetDrawerScreen(viewModel: SheetDrawerViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberBottomSheetScaffoldState()

    LaunchedEffect(uiState.showDrawer) {
        if (uiState.showDrawer) drawerState.open() else drawerState.close()
    }

    LaunchedEffect(uiState.showBottomSheet) {
        if (uiState.showBottomSheet) bottomSheetState.bottomSheetState.expand()
        else bottomSheetState.bottomSheetState.partialExpand()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Navigation", modifier = Modifier.padding(16.dp))
                DrawerItem(icon = Icons.Default.Settings, label = "Settings") {
                    viewModel.closeDrawer()
                }
            }
        }
    ) {
        BottomSheetScaffold(
            scaffoldState = bottomSheetState,
            sheetPeekHeight = 0.dp,
            sheetContent = {
                FilterSheetContent(
                    options = uiState.filterOptions,
                    onSelect = { viewModel.selectFilter(it) }
                )
            },
            content = { padding ->
                MainContent(
                    modifier = Modifier.padding(padding),
                    onDrawerClick = { viewModel.toggleDrawer() },
                    onFilterClick = { viewModel.toggleSheet() }
                )
            }
        )
    }
}

@Composable
fun DrawerItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = label)
    }
}

@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    onDrawerClick: () -> Unit,
    onFilterClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onDrawerClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
            IconButton(onClick = onFilterClick) {
                Icon(Icons.Default.FilterList, contentDescription = "Filter")
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text("Welcome to the Sheet & Drawer Demo!", style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
fun FilterSheetContent(
    options: List<FilterOption>,
    onSelect: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text("Select Filter", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        options.forEachIndexed { index, option ->
            FilterChip(option = option, onClick = { onSelect(index) })
        }
    }
}

@Composable
fun FilterChip(option: FilterOption, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = option.isSelected, onClick = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(option.label)
    }
}