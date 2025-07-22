package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.compose.R

@Preview(showBackground = true)
@Composable
fun CreateColumn() {
    var scrollState = rememberScrollState()
//Create a vertical list of Text, Button, and Image
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).verticalScroll(scrollState), // optional padding
        verticalArrangement = Arrangement.spacedBy(16.dp), // spacing between items
        horizontalAlignment = Alignment.CenterHorizontally // center horizontally
    ) {
        Text(text = "Welcome to Jetpack Compose!", fontSize = 20.sp)

        Button(onClick = { /* Handle click */ }) {
            Text(text = "Click Me")
        }

        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Sample Image",
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        //Use Modifier.padding() and Modifier.fillMaxWidth() inside Column
        // Example usage of Modifier.padding() and Modifier.fillMaxWidth() on children inside the Column:

        Text(
            text = "This Text uses fillMaxWidth and padding",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Button(
            onClick = { /* Handle another click */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(text = "Full Width Button")
        }

        //Apply vertical spacing between children using Spacer

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to Jetpack Compose!",
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(16.dp)) // space between Text and Button

                Button(onClick = {   }) {
                    Text(text = "Click Me")
                }

                Spacer(modifier = Modifier.height(16.dp)) // space between Button and Image

                Image(
                    painter = painterResource(id = R.drawable.pumpkin),
                    contentDescription = "Sample Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }


//Nest another Column to simulate grouped sections
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Group 1: Text + Button
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(0xFFE0F7FA), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Group 1: Greeting", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(12.dp))

                    Button(onClick = { /* Do something */ }) {
                        Text("Say Hello")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp)) // space between groups

                // Group 2: Image only
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color(0xFFF1F8E9), shape = RoundedCornerShape(8.dp))
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Group 2: Image", fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        painter = painterResource(id = R.drawable.pumpkin),
                        contentDescription = "Sample Image",
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                }
            }

    }
}