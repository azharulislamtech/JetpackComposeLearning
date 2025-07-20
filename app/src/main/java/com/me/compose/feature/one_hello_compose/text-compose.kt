package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Preview
@Composable
fun CreateText(name: String = "World") {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Assalaamu Alaikum $name",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 2.sp
            ),
            textAlign = TextAlign.Center,
        )
        Box(
            modifier = Modifier
                .padding(top = 25.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Welcome to the world of Compose $name",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
        }
        //
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.secondary,
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .padding(top = 20.dp)
                .height(160.dp)
                .width(180.dp),
            onClick = { /* Your click action */ }, // Surface is clickable by default when onClick is provided!
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Text use as a card",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(200.dp)
                .height(100.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Blue),
            contentAlignment = Alignment.Center

        ) {
            Text(
                "This is a very long text that needs to fit in the box",
                maxLines = 2,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize(),
                color = Color.White,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis
            )
        }
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Arrow",
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Text with icon",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        /*todo 📐 Layout Behavior
           Test maxLines and overflow = TextOverflow.Ellipsis
           Use Modifier.fillMaxWidth() to stretch the text area
           Apply padding, background, and corner rounding*/
        Box(
            modifier = Modifier
                .padding(top = 20.dp)//Use outer padding for layout/separation between elements.
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                .padding(12.dp)//Use inner padding for readability/appearance within visual components cards, buttons, colored boxes, etc.
                .clip(RoundedCornerShape(12.dp)),

        ) {
            Text(
                text = "This is a text with layout behavior. This is a very long line just to demonstrate maxLines and ellipsis overflow in Jetpack Compose!",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }

        /*todo ⌨️ Dynamic & State-driven Text
           Create a state-bound Text that updates with a button click
           Display real-time input from a TextField
           Format dynamic strings like "Welcome, $username!"*/

        Text("Dynamic & State-driven Text")

        var username by remember { mutableStateOf("") }
        var welcomeMessage by remember { mutableStateOf("Welcome!") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                textStyle = TextStyle(color = Color.Black),
                value = username,
                onValueChange = { username = it },
                label = { Text("Enter your name") },
                modifier = Modifier.fillMaxWidth(),

            )
            Button(
                onClick = {
                    welcomeMessage = if (username.isNotBlank())
                        "Welcome, $username!"
                    else
                        "Welcome!"
                },
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Text("Show Welcome")
            }
            Text(
                welcomeMessage,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 16.dp)
            )
        }


        /*todo:💡 Accessibility & Semantics
           Test readability with contrast on dark/light backgrounds
           Use ContentDescription where needed for screen readers*/
        Text("Accessibility & Semantics")

        // Accessibility demonstration
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Good contrast on dark background
            Box(
                modifier = Modifier
                    .background(Color.Black, RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    "High Contrast: Light text on dark background",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .semantics {
                            contentDescription = "This text is easy to read on a dark background"
                        }
                )
            }

            // Good contrast on light background
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    "High Contrast: Dark text on light background",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .semantics {
                            contentDescription = "This text is easy to read on a light background"
                        }
                )
            }

            // Icon with content description for screen readers
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 20.dp, bottom = 30.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Move forward",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Accessible icon & text",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
        // TODO: 🧪 Previews & Testing
        //  Add @Preview annotations with different text styles
        //  Create multiple text samples in preview to compare typography
        Text("Previews & Testing", style = MaterialTheme.typography.headlineMedium)

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Display Large", style = MaterialTheme.typography.displayLarge)
            Text("Headline Medium", style = MaterialTheme.typography.headlineMedium)
            Text("Title Small", style = MaterialTheme.typography.titleSmall)
            Text("Body Large", style = MaterialTheme.typography.bodyLarge)
            Text("Body Medium", style = MaterialTheme.typography.bodyMedium)
            Text("Label Small", style = MaterialTheme.typography.labelSmall)
            // Add more if desired
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Large", style = MaterialTheme.typography.displayLarge)
            Text("Medium", style = MaterialTheme.typography.bodyMedium)
            Text("Small", style = MaterialTheme.typography.labelSmall)
        }
    }

}