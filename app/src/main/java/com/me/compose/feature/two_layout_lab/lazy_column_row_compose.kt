package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    }
}

