package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CreateRow() {

    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
       //Place Icon + Text side by side using a Row
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
            Text(
                text = "Favorite",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        //Space items evenly with Arrangement.SpaceBetween
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Start")
            Text(text = "Middle")
            Text(text = "End")
        }

        //Align items vertically (verticalAlignment = Alignment.CenterVertically)
        Row(
            modifier = Modifier
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite"
            )
            Text(
                text = "Aligned Center",
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        //Use weighted items with Modifier.weight() for responsive layout
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Weighted 1",
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Weighted 2",
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Weighted 3",
                modifier = Modifier.weight(3f)
            )
        }

//Nest a Column inside a Row for mixed orientation
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Row Item 1")
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Column Item 1")
                Text(text = "Column Item 2")
                Text(text = "Column Item 3")
                Text(text = "Column Item 4")
                Text(text = "Column Item 5")
            }
            Text(text = "Row Item 2")
        }

    }

}