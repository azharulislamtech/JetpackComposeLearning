package com.me.compose

import CustomerListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.me.compose.feature.two_layout_lab.CreateLazyColumnRow
import com.me.compose.feature.two_layout_lab.presentation.DynamicDataScreen
import com.me.compose.feature.two_layout_lab.presentation.component.TodoApp
import com.me.compose.feature.two_layout_lab.presentation.view.ProductScreen
import com.me.compose.ui.theme.JetpackComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeLearningTheme {

//                CreateText("Azharul Islam")
//                CreateButton()
//                CreateImage()
//                CreateSpacer()
//                CreateSurface()
//                CreateModifier()
//                CreateColumn()
//                CreateRow()
//                CreateBox()
//                CreateMixedLayout()
//                CreateLazyColumnRow()
                DynamicDataScreen()
//                TodoApp()
//                CustomerListScreen()

            }
        }
    }
}

