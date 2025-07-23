package com.me.compose.feature.two_layout_lab.presentation

import CustomerListScreen
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.two_layout_lab.data.repository.CustomerProfileRepository
import com.me.compose.feature.two_layout_lab.data.repository.ProductRepository
import com.me.compose.feature.two_layout_lab.data.repository.UserProfileRepository
import com.me.compose.feature.two_layout_lab.domain.GetCustomerProfileUseCase
import com.me.compose.feature.two_layout_lab.domain.GetUserProfilesUseCase
import com.me.compose.feature.two_layout_lab.presentation.component.UserListEvenOddScreen
import com.me.compose.feature.two_layout_lab.presentation.component.UserListScreen
import com.me.compose.feature.two_layout_lab.presentation.component.UserListWithIndexScreen
import com.me.compose.feature.two_layout_lab.presentation.pegination.data.remote.ApiService
import com.me.compose.feature.two_layout_lab.presentation.pegination.data.repository.UserRepository
import com.me.compose.feature.two_layout_lab.presentation.pegination.view.UserListScreen
import com.me.compose.feature.two_layout_lab.presentation.pegination.viewmodel.UserViewModel
import com.me.compose.feature.two_layout_lab.presentation.view.ProductScreen
import com.me.compose.feature.two_layout_lab.presentation.viewmodel.ProductViewModel

@Composable
fun DynamicDataScreen() {
    /*   val viewModel = remember {
           UserProfileViewModel(GetUserProfilesUseCase(UserProfileRepository()))
       }
      // UserProfileListScreen(viewModel)
   //    UserListScreen(viewModel)
   //    UserListWithIndexScreen(viewModel)
     //  UserListEvenOddScreen(viewModel)*/
    /*   val viewModel1 = remember {
           CustomerProfileViewModel(GetCustomerProfileUseCase(CustomerProfileRepository()))
       }
       CustomerListScreen(viewModel1)*/
    val viewModel2 = remember {
        ProductViewModel(ProductRepository())
    }
    //  ProductScreen(viewModel2)
    val apiService = ApiService()
    val repository = UserRepository(apiService)
    val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(repository) as T
        }
    }

    val viewModel: UserViewModel = viewModel(factory = viewModelFactory)
    UserListScreen(viewModel)


}



