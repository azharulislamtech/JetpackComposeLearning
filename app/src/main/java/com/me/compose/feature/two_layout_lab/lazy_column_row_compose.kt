package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable

fun CreateLazyColumnRow() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Static list of Text items
        items(5) { index ->
            Text(
                text = "Item #${index + 1}",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        // Horizontal LazyRow inside LazyColumn
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) { index ->
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = "Placeholder Image $index",
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
        }

        // Static list from stringList
        items(listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")) { item ->
            Text(
                text = item,
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }

        // Vertical LazyColumn section with spacing (still using parent LazyColumn)
        items(5) { index ->
            Text(
                text = "LazyColumn Item #${index + 1}",
                modifier = Modifier.padding(8.dp)
            )
        }

        // Another LazyRow with spacing
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(8) { index ->
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_report_image),
                        contentDescription = "LazyRow Image $index",
                        modifier = Modifier.size(60.dp)
                    )
                }
            }
        }

        // Make the list scrollable by default with Modifier.fillMaxHeight()
        // To make the list scrollable by default, ensure the LazyColumn fills the height.
        // Example: add Modifier.fillMaxHeight() to the outer modifier if not already present.
        // (Already applied: fillMaxSize includes fillMaxHeight, so nothing else needed here.)

        //  Set fixed item height/width and explore visibility impacts

        // Fixed item height for LazyColumn items
        items(3) { index ->
            Text(
                text = "Fixed Height Item ${index + 1}",
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(80.dp) // Each item has a fixed height of 80.dp
            )
        }

        // Row of boxes with fixed width and height
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(10) { idx ->
                    androidx.compose.foundation.layout.Box(
                        modifier = Modifier
                            .size(width = 70.dp, height = 40.dp) // Fixed width and height
                    ) {
                        Text(
                            text = "Box $idx",
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }

        // Tall item to test scroll/visibility
        item {
            Text(
                text = "Very tall item (200.dp height)",
                modifier = Modifier
                    .padding(6.dp)
                    .height(200.dp)
            )
        }

        // Wide row of images with even larger fixed width
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(5) { index ->
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_delete),
                        contentDescription = "Wide Image $index",
                        modifier = Modifier.size(width = 120.dp, height = 60.dp)
                    )
                }
            }
        }

        // Use Modifier.weight() inside list items (advanced composition)
        // Demonstrating Modifier.weight() usage inside a LazyRow within a LazyColumn item
        item {
            // Each item in the row will take equal weight and fill the available width
            Row(
                modifier = Modifier
                    .padding(vertical = 12.dp)
                    .height(56.dp)
            ) {
                Text(
                    text = "Weighted 1",
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
                Text(
                    text = "Weighted 2",
                    modifier = Modifier
                        .weight(2f)
                        .padding(8.dp)
                )
                Text(
                    text = "Weighted 3",
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                )
            }
        }

        // Correct usage of weight by wrapping LazyRow -> Row
        item {
            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .height(80.dp)
                    .fillMaxWidth()
            ) {
                repeat(5) { idx ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 6.dp)
                    ) {
                        Image(
                            painter = painterResource(id = android.R.drawable.ic_menu_camera),
                            contentDescription = "Weighted Image $idx",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
// Add dividers between items using Divider()

        // Add dividers between items using Divider()
        // We'll add a Divider() after each main item (except after the last one) for visual separation

        // Example: Dividers between some text items
        items(3) { index ->
            Column {
                Text(
                    text = "Divider Demo Item #${index + 1}",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                if (index < 2) {
                   Divider(Modifier.padding(vertical = 4.dp))
                }
            }
        }

        // Example: Dividers between images in a LazyRow inside the LazyColumn
        item {
            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                items(4) { idx ->
                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = android.R.drawable.ic_menu_call),
                            contentDescription = "Row Image $idx",
                            modifier = Modifier.size(44.dp)
                        )
                        if (idx < 3) {
                            Divider(
                                modifier = Modifier
                                    .height(40.dp)
                                    .width(1.dp)
                                    .padding(horizontal = 4.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// General guideline: For dividers in LazyColumn, wrap item content in a Column and place Divider below, except for the last item.


