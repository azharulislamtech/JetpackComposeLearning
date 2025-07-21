package com.me.compose.feature.one_hello_compose

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.me.compose.ui.components.spacer.HorizontalSpacer
import com.me.compose.ui.components.spacer.SpacerGrid
import com.me.compose.ui.components.spacer.VerticalSpacer


@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CreateSpacer() {

    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Text(
            "\uD83D\uDD30 Basic Usage",
            style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
        )

        Text("Hello Spacer!")
        Spacer(modifier = Modifier.height(16.dp))
        Text("This text is below the spacer.")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Left Item")
            Spacer(modifier = Modifier.width(24.dp))
            Text("Right Item")
        }

        //todo: Try multiple Spacer components with fixed dimensions in a layout
        Spacer(modifier = Modifier.height(24.dp))
        Text("This is after a 24.dp Spacer")

        Spacer(modifier = Modifier.height(32.dp))
        Text("This is after a 32.dp Spacer")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Item 1")
            Spacer(modifier = Modifier.width(16.dp))
            Text("Item 2")
            Spacer(modifier = Modifier.width(24.dp))
            Text("Item 3")
        }

        //🔧 Modifier Experimentation
        Text(
            "\uD83D\uDD27 Modifier Experimentation",
            style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
        )
        //Test Spacer with Modifier.fillMaxWidth() and fillMaxHeight()
        // Spacer that fills max width with fixed height, acts as a horizontal divider space
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
        )
        Text("This text is after a Spacer that fills max width but is only 12.dp tall.")

        Row(
            modifier = Modifier
                .height(60.dp)
        ) {
            Text("Left")
            // Spacer fills remaining horizontal space in the row
            Spacer(modifier = Modifier.weight(1f))
            Text("Right")
        }
        Spacer(modifier = Modifier.height(12.dp))

        // Box to demonstrate fillMaxHeight
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxHeight()
            ) {
                Text("Top")
                // Spacer fills as much vertical space as possible inside the row (though usually Column is better)
                Spacer(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(20.dp)
                )
                Text("Bottom")
            }
        }

        //todo: Combine Spacer with padding() or background() to visualize layout impact
        // Spacer with background to visualize its space and some padding around it
        Text("Spacer with background (Red, 40.dp height, 8.dp padding):")
        Spacer(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(40.dp)
                .background(MaterialTheme.colorScheme.error.copy(alpha = 0.3f))
        )
        Text("Below the red background spacer.")

        // Spacer with both background and horizontal padding inside a row
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Item A")
            Spacer(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .width(36.dp)
                    .height(24.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
            )
            Text("Item B")
        }
        Text("Above: Spacer with blue background and horizontal padding.")

        // Spacer with round background (for demonstration)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Left")
            Spacer(
                modifier = Modifier
                    .padding(8.dp)
                    .size(32.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f),
                        shape = MaterialTheme.shapes.medium
                    )
            )
            Text("Right")
        }
        Text("Above: Spacer with background and shape.")

        //Try responsive spacing with %-based logic inside BoxWithConstraints or conditionally sized Modifier

        // Responsive Spacer using BoxWithConstraints
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f))
        ) {
            val spacerHeight = maxHeight * 0.15f // Spacer is 15% of available maxHeight
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Responsive Spacer below (15% of max Height)")
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth(0.7f) // 70% of the Box width
                        .height(spacerHeight)
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f))
                )
                Text("Below responsive spacer (height = ${(spacerHeight.value).toInt()} dp)")
            }
        }

        // Another responsive width example in a Row
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.06f))
        ) {
            val spacerWidth = maxWidth * 0.25f // 25% of BoxWithConstraints width
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start")
                Spacer(
                    modifier = Modifier
                        .width(spacerWidth)
                        .height(24.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f))
                )
                Text("End")
            }
        }


        Text(
            "\uD83D\uDCD0 Layout Composition",
            style = MaterialTheme.typography.titleMedium.copy(textDecoration = TextDecoration.Underline)
        )
// Vertical form layout example using Column and Spacer
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 32.dp, start = 8.dp, end = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Name",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material3.OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter your name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Email",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            androidx.compose.material3.OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter your email") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.height(4.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Enter your password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { /* Handle sign up click */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Sign Up")
            }
        }

//Build a Row of icons/text with equal gaps using multiple Spacers
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Example: 3 icons (here as text), equally spaced
            Text("🏠")
            Spacer(modifier = Modifier.weight(1f))
            Text("🔔")
            Spacer(modifier = Modifier.weight(1f))
            Text("📧")
        }
        
        //Use flexible Spacer(modifier = Modifier.weight(1f)) to push items to edges
        // Row demonstrating Spacer with weight to push items to edges
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Start edge")
            Spacer(modifier = Modifier.weight(1f))
            Text("End edge")
        }
        
        //Align two buttons at opposite ends of a Row using Spacer(weight = 1f) between them
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* Handle left button click */ }) {
                Text("Left Button")
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { /* Handle right button click */ }) {
                Text("Right Button")
            }
        }

        Text("\uD83C\uDFA8 Design & Visual Balance",style=MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline))

        // Create a hero section where Spacer pushes headline text to vertical center
        // Hero section: Use Column + Spacer to vertically center headline text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Welcome to Jetpack Compose!",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        
        //Add Spacer as a separator between sections with a divider or background color
        // Spacer as a section separator with a divider background
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .padding(vertical = 12.dp)
                .background(MaterialTheme.colorScheme.outline)
        )

        // Spacer as a section separator with a soft colored background bar
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .padding(vertical = 8.dp)
                .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f))
        )
        
        //Adjust layout spacing dynamically with scrollable content
        // Example: Dynamically adjust Spacer size based on scroll position
        
        // We'll use scrollState to alter the spacer height dynamically
        val dynamicSpacerHeight = (8 + (scrollState.value / 20)).coerceIn(8, 64).dp
        Text("Dynamic Spacer below (height changes with scroll: ${dynamicSpacerHeight.value.toInt()} dp)")
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(dynamicSpacerHeight)
                .background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.22f))
        )
        Text("Keep scrolling: The colored spacer above grows taller as you scroll more!")

        Text("\uD83D\uDD01 Reusability & Cleanup", style=MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline))

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Username")
            TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

            VerticalSpacer()

            Text("Password")
            TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

            VerticalSpacer(height = 24.dp)

            Button(onClick = { /* Submit */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Login")
            }
        }

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
            HorizontalSpacer(width = 8.dp)
            Text("Profile")
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text("Name")
            TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

            SpacerGrid(units = 2) // 16.dp

            Text("Email")
            TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth())

            SpacerGrid(units = 3) // 24.dp

            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Submit")
            }
        }

        Column {
            Text("Item 1")
            SpacerGrid(1)
            Text("Item 2")
            SpacerGrid(2)
            Text("Item 3")
        }


    }

}