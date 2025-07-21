package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.me.compose.R

@Composable
fun CreateModifier(){

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "\uD83D\uDCE6 Modifier Basic", style = MaterialTheme.typography.headlineMedium.copy(
                textDecoration = TextDecoration.Underline
            )
        )
        Text(
            "\uD83D\uDCCF Size & Dimension", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        //Use Modifier.width(200.dp) and Modifier.height(50.dp) to set fixed sizes
        Text(
            text = "Fixed size box (200x60 dp)",
            modifier = Modifier
                .width(200.dp)
                .height(60.dp)
                .padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        //Try Modifier.size(100.dp) and explore square vs. rectangular sizing
        // Square sizing with Modifier.size(100.dp)
        Text(
            text = "Square box (100x100 dp)",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        // Rectangular sizing with Modifier.size(width, height)
        Text(
            text = "Rectangular box (120x60 dp)",
            modifier = Modifier
                .size(width = 120.dp, height = 60.dp)
                .padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        
        //Apply fillMaxWidth() or fillMaxSize() to stretch composables within layout
        // Demonstrate stretching a Text to full width using fillMaxWidth()
        Text(
            text = "This box stretches to fill max width",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(50.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        // Demonstrate stretching a Text to fill all available space using fillMaxSize()
        // For composables inside a Column, fillMaxSize will typically fill width
        // and take remaining available height within the parent.
        Text(
            text = "This box fills max size (try in Box or parent with fixed height)",
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    
        Text(
            "\uD83C\uDFA8 Padding & Background", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )
        //Add internal spacing with Modifier.padding(16.dp)
        Text(
            text = "This text has 16.dp padding inside its bounds",
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        //Apply asymmetric padding like Modifier.padding(start = 8.dp, end = 16.dp)
        Text(
            text = "This text has asymmetric padding (start = 8.dp, end = 16.dp)",
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        //Use background(Color.LightGray) for visual debugging
        Text(
            text = "This text has a LightGray background for debugging",
            modifier = Modifier
                .background(Color.LightGray)
                .padding(12.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        //Combine padding + background to simulate card appearance
        Text(
            text = "This text looks like a card with rounded corners",
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(20.dp)
                .fillMaxWidth()
                .background(
                    color = Color.LightGray,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(4.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Text("\uD83E\uDDF1 Borders & Shape",style = MaterialTheme.typography.headlineSmall.copy(
            textDecoration = TextDecoration.Underline))
        //Add borders using Modifier.border(2.dp, Color.Blue)
        // Simple border with solid color
        Text(
            text = "Text with 2.dp Blue border",
            modifier = Modifier
                .border(2.dp, Color.Blue)
                .padding(12.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        // Border with rounded corners
        Text(
            text = "Rounded border (medium shape, 2.dp Blue)",
            modifier = Modifier
                .border(2.dp, Color.Blue, shape = MaterialTheme.shapes.medium)
                .padding(12.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        
        //Clip composables with RoundedCornerShape using Modifier.clip()
        // Example: Clipping a composable with RoundedCornerShape using Modifier.clip()
        Text(
            text = "Clipped with 16.dp RoundedCornerShape",
            modifier = Modifier
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp))
                .background(Color.Magenta)
                .padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        
        //Combine border + clip for styled containers (e.g. avatar or pill buttons)
        // Demonstrate combining border + clip (pill style label/button)
        Text(
            text = "Pill style with border + clip",
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .border(
                    width = 2.dp,
                    color = Color.Green,
                    shape = RoundedCornerShape(50)
                )
                .background(Color(0xFFBBFFCC))
                .padding(horizontal = 24.dp, vertical = 10.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        
        // Example: circular avatar-like composable combining border and clip
     Image(
            painter = painterResource(
                id = R.drawable.pumpkin // use your resource here
            ),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Magenta, shape = CircleShape)
                .background(Color.LightGray),
        )

        Text("\uD83D\uDCD0 Alignment & Arrangement",style = MaterialTheme.typography.headlineSmall.copy(
            textDecoration = TextDecoration.Underline))
        //Center a Text inside Box using Modifier.align(Alignment.Center)
       Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color(0xFFD0E8FF), shape = RoundedCornerShape(12.dp))
        ) {
            Text(
                text = "Centered Text",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF004080)
            )
        }
        
        // Position components in Row with weighted Modifier.weight(1f)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .background(Color(0xFFF0F4F8), shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Weight 1",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFB2DFDB))
                    .padding(12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Weight 2",
                modifier = Modifier
                    .weight(2f)
                    .background(Color(0xFFFFF9C4))
                    .padding(12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Weight 1",
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFFFCCBC))
                    .padding(12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
        
        //Add spacing between items with Spacer and Modifier tricks
        // Using Spacer for vertical spacing in Column
        Text(
            text = "Above Spacer (Column vertical)",
            style = MaterialTheme.typography.bodyLarge
        )
        androidx.compose.foundation.layout.Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Below Spacer (24.dp gap above)",
            style = MaterialTheme.typography.bodyLarge
        )

        // Spacer in Row for horizontal space
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Left",
                style = MaterialTheme.typography.bodyLarge
            )
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = "Right (32.dp to left)",
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Using Modifier.padding between composables for spacing
        Text(
            text = "Top Text with bottom padding",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "This text is 16.dp below above one",
            style = MaterialTheme.typography.bodyLarge
        )

        Text("\uD83C\uDFAF Clickability & Interaction",style = MaterialTheme.typography.headlineSmall.copy(
            textDecoration = TextDecoration.Underline))
        
        // Make a Surface or Box clickable with Modifier.clickable { }
        // Example: Clickable Box that changes color when clicked
        var isClicked = remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(100.dp)
                .background(
                    if (isClicked.value) Color(0xFF80CBC4) else Color(0xFFE57373),
                    shape = RoundedCornerShape(12.dp)
                )
                .border(2.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                .clickable { isClicked.value = !isClicked.value },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isClicked.value) "Clicked!" else "Click Me",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Example: Clickable Surface (a Material style container)
       Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFFB39DDB),
            tonalElevation = 4.dp,
            shadowElevation = 8.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .height(56.dp)
                .clickable { /* Handle click here */ }
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Clickable Surface",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        //Add ripple feedback using indication = rememberRipple()
        // Example: Box with custom ripple effect using indication = rememberRipple()
        Box(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .size(100.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null // OR omit this line entirely to use theme default
                ) { /* Handle ripple click */ }
                .background(Color(0xFF64B5F6), shape = RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ripple Demo",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Combine pointerInput {} for touch gestures or drag experiments (advanced)
        // Example: Basic drag gesture using pointerInput and Modifier.offset
        var offsetX = remember { mutableStateOf(0f) }
        var offsetY = remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .size(100.dp)
                .offset { androidx.compose.ui.unit.IntOffset(offsetX.value.toInt(), offsetY.value.toInt()) }
                .background(Color(0xFFFFD54F), shape = RoundedCornerShape(16.dp))
                .border(2.dp, Color(0xFFFFA000), shape = RoundedCornerShape(16.dp))
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        offsetX.value += dragAmount.x
                        offsetY.value += dragAmount.y
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Drag Me!",
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        //
        Text("\uD83D\uDD04 Chaining Modifiers",style = MaterialTheme.typography.headlineSmall.copy(
            textDecoration = TextDecoration.Underline))
        // Chain multiple modifiers like .padding().background().clickable()
        Box(
            modifier = Modifier
                .padding(16.dp) // Outer spacing around the Box
                .background(Color(0xFF64B5F6), shape = RoundedCornerShape(12.dp)) // Background with shape
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null // Use Material3 default ripple, or customize
                ) {
                    // Handle click
                }
                .padding(24.dp), // Inner padding (space inside the clickable area)
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Ripple Demo",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
//Test order sensitivity (e.g. padding before background vs. after)
        Box(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Blue)
                .size(100.dp)
        )
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .padding(16.dp)
                .size(100.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.Blue)
                .clickable { /* click */ }
                .padding(16.dp)
        )
        Box(
            modifier = Modifier
                .clickable { /* click */ }
                .background(Color.Blue)
                .padding(16.dp)
        )

        /*Recommended Order for Ripple with Background and Padding
        * Modifier
    .padding(8.dp)                          // Outer margin
    .background(Color.Blue)                // Shape and visual base
    .clickable { /* click */ }             // Ripple effect on top
    .padding(16.dp)                        // Inner padding for content

        * */


        Box(
            modifier = Modifier
                .cardStyle(backgroundColor = Color(0xFF64B5F6))
                .clickable { /* Handle click */ },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Card Style Box",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }



    }

}


fun Modifier.cardStyle(
    backgroundColor: Color = Color.White,
    cornerRadius: Dp = 12.dp,
    elevation: Dp = 4.dp,
    padding: Dp = 16.dp
): Modifier = this
    .padding(padding)
    .shadow(elevation, shape = RoundedCornerShape(cornerRadius))
    .background(backgroundColor, shape = RoundedCornerShape(cornerRadius))