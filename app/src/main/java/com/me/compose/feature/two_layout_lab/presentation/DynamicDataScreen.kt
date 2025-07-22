package com.me.compose.feature.two_layout_lab.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.me.compose.feature.two_layout_lab.data.repository.UserProfileRepository
import com.me.compose.feature.two_layout_lab.domain.GetUserProfilesUseCase
import com.me.compose.feature.two_layout_lab.presentation.component.UserListEvenOddScreen
import com.me.compose.feature.two_layout_lab.presentation.component.UserListScreen
import com.me.compose.feature.two_layout_lab.presentation.component.UserListWithIndexScreen

@Composable
fun DynamicDataScreen() {
    val viewModel = remember {
        UserProfileViewModel(GetUserProfilesUseCase(UserProfileRepository()))
    }
   // UserProfileListScreen(viewModel)
//    UserListScreen(viewModel)
//    UserListWithIndexScreen(viewModel)
    UserListEvenOddScreen(viewModel)
}



