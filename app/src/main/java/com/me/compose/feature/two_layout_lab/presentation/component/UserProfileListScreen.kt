package com.me.compose.feature.two_layout_lab.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.two_layout_lab.presentation.UserProfileViewModel


@Composable
fun UserProfileListScreen(viewModel: UserProfileViewModel) {
    val profiles by viewModel.userProfiles.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(profiles) { profile ->
            UserProfileItem(profile = profile)
            Divider()
        }
    }
}
