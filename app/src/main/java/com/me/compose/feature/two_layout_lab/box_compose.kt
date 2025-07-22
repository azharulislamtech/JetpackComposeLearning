package com.me.compose.feature.two_layout_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.me.compose.R

@Preview(showBackground = true)
@Composable
fun CreateBox() {
    var scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Overlay Text on an Image using Box
        Box(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_camera),
                contentDescription = "Camera Image"
            )
            Text(
                text = "Overlay Text",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }

//Another overlay example
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Sample Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Semi-transparent overlay (optional)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            // Overlay Text
            Text(
                text = "Overlay Text",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

//Align children in corners using Modifier.align()
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(top = 26.dp)
                .background(Color.LightGray)
        ) {
            // Top Start (Top Left)
            Text(
                text = "Top Start",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
            )

            // Top End (Top Right)
            Text(
                text = "Top End",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
            )

            // Bottom Start (Bottom Left)
            Text(
                text = "Bottom Start",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )

            // Bottom End (Bottom Right)
            Text(
                text = "Bottom End",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
            )
        }

//Center content using Box(contentAlignment = Alignment.Center)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
                .background(Color(0xFFE0F7FA)),
            contentAlignment = Alignment.Center // <-- This centers the child
        ) {
            Text(
                text = "Centered Text",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }


       //Use Box with background color + padding to simulate a card

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Outer spacing
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp) // Rounded corners
                )
                .shadow(4.dp, shape = RoundedCornerShape(12.dp)) // Optional shadow
                .padding(16.dp) // Inner content padding
        ) {
            Column {
                Text(
                    text = "Title",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This is a description inside a card-like Box.",
                    fontSize = 14.sp
                )
            }
        }


        //Nest Box inside Column or Row for visual sections

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF1976D2), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Header Section",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Content section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .shadow(2.dp, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "This is a content box inside a Column.",
                    fontSize = 16.sp
                )
            }

            // Footer section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Footer Section",
                    fontSize = 16.sp
                )
            }
        }


    }

}