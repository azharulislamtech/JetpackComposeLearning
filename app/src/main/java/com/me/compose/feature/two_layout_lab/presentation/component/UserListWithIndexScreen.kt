package com.me.compose.feature.two_layout_lab.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.compose.feature.two_layout_lab.presentation.UserProfileViewModel

@Composable
fun UserListWithIndexScreen(viewModel: UserProfileViewModel) {
    val userProfiles by viewModel.userProfiles.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        itemsIndexed(userProfiles) { index, user ->

            // Example index-based logic:
            if (index % 2 == 0) {
                Text(
                    text = "Even Index #$index",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            UserCard(user)

            // Add divider after every item except the last one
            if (index < userProfiles.lastIndex) {
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}
