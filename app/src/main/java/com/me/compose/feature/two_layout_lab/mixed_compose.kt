package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.me.compose.ui.components.layout.DashboardScreen
import com.me.compose.ui.components.layout.DashboardScreenGrok
import com.me.compose.ui.components.layout.HorizontalButtonBar
import com.me.compose.ui.components.layout.ProfileCard

@Preview(showBackground = true)
@Composable
fun CreateMixedLayout() {
    //Create a profile card layout: Image + Text using Column inside Box
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
  //Create a profile card layout: Image + Text using Column inside Box
        ProfileCard(
            name = "Azharul Islam",
            designation = "Senior Android Developer",
            imageUrl = "https://i.postimg.cc/rqmp34xr/profile1.jpg"
        )

//Build a horizontal button bar using Row with equal spacing
        HorizontalButtonBar(
            buttonLabels = listOf("Home", "Profile", "Settings")
        ) { clickedLabel ->
            // Handle click for each button here
            println("Clicked: $clickedLabel")
        }

//Develop a dashboard screen combining all three (Box for header, Column for content, Row for actions)
        val stats = listOf("Orders: 12", "Revenue: $1,200", "New Customers: 5")
        val actions = listOf("Add Order", "View Reports", "Settings")

        DashboardScreen(
            userName = "Azharul",
            stats = stats,
            actionLabels = actions,
            onActionClick = { action -> println("Clicked $action") }
        )

        DashboardScreenGrok()

    }

}