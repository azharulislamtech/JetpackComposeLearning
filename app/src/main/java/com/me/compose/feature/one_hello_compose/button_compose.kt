package com.me.compose.feature.one_hello_compose

import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.launch

@Preview
@Composable
fun CreateButton() {
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }
    var showExtra by remember { mutableStateOf(false) }
    var isStarted by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()
    var buttonText by remember { mutableStateOf("Click Me") }
    val context = LocalContext.current

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                " Basic Implementation",
                style = MaterialTheme.typography.headlineSmall.copy(
                    textDecoration = TextDecoration.Underline
                )
            )
            Button(onClick = { buttonText = "You clicked me!" }) {
                Text(buttonText)
            }
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Button was clicked!")
                    }
                }
            ) { Text("Click Me") }
            Button(onClick = {
                Toast.makeText(context, "Button was clicked!", Toast.LENGTH_SHORT).show()
            }) { Text("Click Me") }

            Text(
                "Styling Variants", style = MaterialTheme.typography.headlineSmall.copy(
                    textDecoration = TextDecoration.Underline
                )
            )

            Button(
                onClick = { /* Do something! */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)

            ) {
                Text("Click Me")
            }
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text("Click Me")
            }
            Button(
                onClick = { /* Do something! */ },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text("Click Me")
            }
            Button(
                onClick = {},
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 12.dp,      // Default elevation
                    pressedElevation = 4.dp,       // When pressed
                    disabledElevation = 0.dp       // When disabled
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)

            ) {
                Text("Click Me")
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text(
                    "Click Me",
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.LineThrough
                    )
                )
            }

            Text(
                "Stateful Behavior", style = MaterialTheme.typography.titleLarge.copy(
                    textDecoration = TextDecoration.Underline
                )
            )

            Button(
                onClick = { showExtra = !showExtra },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text(if (showExtra) "Hide" else "Show")
            }

            if (showExtra) {
                // Put your extra UI here! For example:
                Text("Here is the hidden content!", color = Color.Blue)
            }

            Button(
                onClick = { isStarted = !isStarted },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text(if (isStarted) "Stop" else "Start")
            }
            LaunchedEffect(isStarted) {
                if (isStarted) {
                    // Runs only when isStarted becomes true
                    delay(3000) // 3 seconds
                    Toast.makeText(context, "3 seconds passed!", Toast.LENGTH_SHORT).show()
                }
            }
            // Example: Disable the "Start/Stop" button when showExtra is true
            Button(
                onClick = { /* Example action: show toast or handle event */ },
                enabled = !showExtra, // The button is disabled when showExtra is true
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {

                Text(
                    if (!showExtra) "Enabled Button" else "Disabled (when showExtra=true)"
                )
            }

            Text(
                "Variations of Buttons",
                style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
            )

            OutlinedButton(
                onClick = { /* Do something! */ },
                border = BorderStroke(2.dp, Color.Green), // Custom border width and color
                shape = RoundedCornerShape(12.dp),          // Optional: custom rounded corners
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text("Outlined Button")
            }

            // TextButton example, compared to Button
            TextButton(
                onClick = {
                    Toast.makeText(context, "You clicked a TextButton!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Text(
                    "This is a TextButton",
                    style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                )
            }
            Text(
                "TextButton is a flat, borderless button. " +
                        "Unlike a filled Button, it offers less emphasis and is best for lower priority actions, " +
                        "such as text-based links or actions that don't need to stand out.",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            IconButton(
                onClick = {
                    Toast.makeText(context, "IconButton clicked!", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Forward",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Button(
                onClick = {
                    Toast.makeText(context, "Icon + Text Button clicked!", Toast.LENGTH_SHORT)
                        .show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Forward",
                    tint = Color.White,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    "Proceed",
                    style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                )
            }

            Text(
                "Reusability & Abstraction", style = MaterialTheme.typography.headlineSmall.copy(
                    textDecoration = TextDecoration.Underline
                )
            )
            @Composable
            fun PrimaryButton(
                onClick: () -> Unit,
                modifier: Modifier = Modifier,
                enabled: Boolean = true,
                text: String,
                icon: (@Composable (() -> Unit))? = null
            ) {
                Button(
                    onClick = onClick,
                    enabled = enabled,
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                        disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f)
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
                    modifier = modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    if (icon != null) {
                        icon()
                    }
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimary
                        ),
                        modifier = if (icon != null) Modifier.padding(start = 8.dp) else Modifier
                    )
                }
            }

            // Example usage:
            PrimaryButton(
                text = "Primary Action",
                onClick = {
                    Toast.makeText(context, "Primary Button clicked!", Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Arrow",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                modifier = Modifier
                    .padding(top = 12.dp)
            )

            var isLoading by remember { mutableStateOf(false) }

            Button(
                onClick = {
                    isLoading = true
                    scope.launch {
                        delay(2000) // Simulate loading for 2 seconds
                        isLoading = false
                        Toast.makeText(context, "Loading Complete!", Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 3.dp,
                        modifier = Modifier
                            .height(24.dp)
                            .padding(end = 8.dp)
                    )
                    Text("Loading...")
                } else {
                    Text("Loading Button")
                }
            }
            // Button Toolbar with multiple actions
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Button Toolbar",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                // Row of icon buttons for typical toolbar actions
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            MaterialTheme.colorScheme.surfaceVariant,
                            RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Share clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Share",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Edit clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward, // Replace with Edit icon if available
                            contentDescription = "Edit",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "Delete clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward, // Replace with Delete icon if available
                            contentDescription = "Delete",
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                    IconButton(onClick = {
                        Toast.makeText(
                            context,
                            "More clicked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward, // Replace with More icon if available
                            contentDescription = "More",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                // Optional: add a label row under the icons for clarity (accessibility)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Share",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Text(
                        "Edit",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Text(
                        "Delete",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                    Text(
                        "More",
                        fontSize = 12.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }
            }

            Text("Testing & Previews",style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline))

              // Multiple styled buttons demo
              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 16.dp),
                  horizontalArrangement = Arrangement.SpaceEvenly,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  Button(
                      onClick = { Toast.makeText(context, "Primary Button", Toast.LENGTH_SHORT).show() },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = MaterialTheme.colorScheme.primary,
                          contentColor = MaterialTheme.colorScheme.onPrimary
                      ),
                      shape = RoundedCornerShape(20),
                  ) {
                      Text("Primary")
                  }
                  OutlinedButton(
                      onClick = { Toast.makeText(context, "Outlined Button", Toast.LENGTH_SHORT).show() },
                      border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
                      shape = RoundedCornerShape(16.dp),
                      colors = ButtonDefaults.outlinedButtonColors(
                          containerColor = Color.Transparent,
                          contentColor = MaterialTheme.colorScheme.secondary
                      )
                  ) {
                      Text("Outlined")
                  }
                  TextButton(
                      onClick = { Toast.makeText(context, "Text Button", Toast.LENGTH_SHORT).show() }
                  ) {
                      Text(
                          "Text",
                          style = MaterialTheme.typography.bodyLarge.copy(
                              color = MaterialTheme.colorScheme.tertiary
                          )
                      )
                  }
                  IconButton(
                      onClick = { Toast.makeText(context, "Icon Only", Toast.LENGTH_SHORT).show() },
                      modifier = Modifier.background(
                          color = MaterialTheme.colorScheme.surfaceVariant,
                          shape = RoundedCornerShape(12.dp)
                      )
                  ) {
                      Icon(
                          imageVector = Icons.Default.ArrowForward,
                          contentDescription = "Arrow Icon",
                          tint = MaterialTheme.colorScheme.primary
                      )
                  }
              }
              Row(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 12.dp),
                  horizontalArrangement = Arrangement.SpaceEvenly,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  Button(
                      onClick = { Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show() },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = Color(0xFF4CAF50),
                          contentColor = Color.White
                      ),
                      shape = RoundedCornerShape(50),
                  ) {
                      Text("Success")
                  }
                  Button(
                      onClick = { Toast.makeText(context, "Warning", Toast.LENGTH_SHORT).show() },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = Color(0xFFFFC107),
                          contentColor = Color.Black
                      ),
                      shape = RoundedCornerShape(50),
                  ) {
                      Text("Warning")
                  }
                  Button(
                      onClick = { Toast.makeText(context, "Danger", Toast.LENGTH_SHORT).show() },
                      colors = ButtonDefaults.buttonColors(
                          containerColor = Color(0xFFF44336),
                          contentColor = Color.White
                      ),
                      shape = RoundedCornerShape(50),
                  ) {
                      Text("Danger")
                  }
              }
             

        }
    }
}