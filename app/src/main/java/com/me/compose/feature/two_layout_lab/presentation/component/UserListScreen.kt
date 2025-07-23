package com.me.compose.feature.two_layout_lab.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.two_layout_lab.presentation.UserProfileViewModel

@Composable
fun UserListScreen(viewModel: UserProfileViewModel) {
    val userProfiles by viewModel.userProfiles.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(userProfiles) { user ->
            UserCard(user)
        }
    }
}
