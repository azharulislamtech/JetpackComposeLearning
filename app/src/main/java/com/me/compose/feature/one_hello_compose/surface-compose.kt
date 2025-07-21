package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.me.compose.R
import com.me.compose.ui.components.surface.AppCardSurface
import com.me.compose.ui.components.surface.SurfaceSection
import com.me.compose.ui.components.surface.UserProfileCard

// Surface Composable Practice

@Composable
fun CreateSurface() {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "\uD83D\uDCE6 Surface Basic Display", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        // Wrap a Text inside a Surface with a background color
        Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shadowElevation = 4.dp,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        ) {
            Text(
                text = "This is inside a Surface!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
            )
        }

        //Add padding to Surface using Modifier.padding()
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            color = MaterialTheme.colorScheme.secondaryContainer,
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = "Surface with extra padding!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(20.dp)
            )
        }

        //Create a card-like UI by applying elevation to Surface
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            shape = MaterialTheme.shapes.large,
            shadowElevation = 8.dp,
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "Card Title",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "This Surface looks like a card with elevated shadow and rounded corners.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }


        Text(
            "\uD83C\uDFA8 Styling & Shape", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        //Use rounded corners with shape = RoundedCornerShape(8.dp)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            color = MaterialTheme.colorScheme.tertiaryContainer,
            shadowElevation = 4.dp,
            shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Surface with Rounded Corners (8.dp)",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier.padding(20.dp)
            )
        }

        // Combine Surface and Modifier.clip() for custom shapes
        Surface(
            color = MaterialTheme.colorScheme.errorContainer,
            shadowElevation = 6.dp,
            // Surface will use a custom, oval shape via clip on its content
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .clip(
                    androidx.compose.foundation.shape.CutCornerShape(
                        topEnd = 24.dp,
                        bottomStart = 24.dp
                    )
                )
        ) {
            Text(
                text = "Surface with custom CutCornerShape using Modifier.clip()!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onErrorContainer,
                modifier = Modifier.padding(24.dp)
            )
        }

        //Apply theme-based colors using MaterialTheme.colorScheme.surface
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 3.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = "Surface with theme-based surface color!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp)
            )
        }


        Text(
            "\uD83D\uDCD0 Layout Integration", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        //Wrap an entire Column of elements inside one Surface
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.large,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "This is an entire Column wrapped",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "All elements below are enclosed by one Surface.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
                Text(
                    text = "• You can put multiple composables here",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "• They inherit the Surface background and shape",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "• Surface also provides elevation shadow",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        //Use Surface as the base container for a user profile card
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 10.dp,
            color = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Placeholder profile picture (can use Image if you have one)
                Canvas(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .clip(androidx.compose.foundation.shape.CircleShape)
                        .fillMaxWidth(0.3f)
                        .aspectRatio(1f)
                ) {
                    drawCircle(
                        color = Color.Gray,
                        radius = size.minDimension / 2
                    )
                }
                Text(
                    text = "Azharul Islam",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Text(
                    text = "Android Developer",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "azharul.islam@email.com",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }


        // Nest multiple Surface components with varying elevations

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
            color = MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.large,
            shadowElevation = 8.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Outermost Surface (Elevation: 8.dp)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 4.dp,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 8.dp)
                        .fillMaxWidth(0.95f)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(18.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Middle Surface (Elevation: 4.dp)",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Surface(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                            shape = MaterialTheme.shapes.small,
                            shadowElevation = 2.dp,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxWidth(0.9f)
                        ) {
                            Text(
                                text = "Innermost Surface (Elevation: 2.dp)",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }

        //
        Text(
            "\uD83C\uDF19 Theming & State", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        // Create a dynamic surface that changes background color based on a state value
        // Dynamic Surface that changes color on click
        var isPrimary by remember { mutableStateOf(true) }
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            color = if (isPrimary) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.tertiaryContainer,
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 6.dp,
            // Toggle color on click
            onClick = { isPrimary = !isPrimary }
        ) {
            Text(
                text = if (isPrimary) "PrimaryContainer Color" else "TertiaryContainer Color",
                style = MaterialTheme.typography.titleMedium,
                color = if (isPrimary) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onTertiaryContainer,
                modifier = Modifier
                    .padding(24.dp)
            )
        }

        //Implement light/dark theme-aware Surface styling

        // Light/dark theme-aware Surface styling example:
        val isDarkTheme = isSystemInDarkTheme()

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            color = if (isDarkTheme) Color(0xFF222831) else Color(0xFFF7F7F7),
            shadowElevation = if (isDarkTheme) 10.dp else 4.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = if (isDarkTheme) "Current: Dark Theme Surface" else "Current: Light Theme Surface",
                style = MaterialTheme.typography.titleMedium,
                color = if (isDarkTheme) Color(0xFFF1F1F1) else Color(0xFF232323),
                modifier = Modifier.padding(24.dp)
            )
        }

        //Apply clickable behavior to a Surface that opens a dialog or toggles content

        // Example: Surface that opens an AlertDialog on click

        var showDialog by remember { mutableStateOf(false) }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = MaterialTheme.shapes.medium,
            shadowElevation = 6.dp,
            onClick = { showDialog = true }
        ) {
            Text(
                text = "Tap me to show a dialog",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(24.dp)
            )
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                },
                title = {
                    Text("Surface Clicked!")
                },
                text = {
                    Text("You tapped the Surface and this dialog appeared.")
                }
            )
        }

        Text(
            "♿ Accessibility & Feedback", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        //Make a Surface touch-responsive with ripple effect using clickable()
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable(
                    onClick = { /* Handle click, e.g., show a toast or log */ },
                    indication = null, // Use default ripple
                    interactionSource = remember { MutableInteractionSource() }
                ),
            color = MaterialTheme.colorScheme.primaryContainer,
            shadowElevation = 4.dp
        ) {
            Text(
                text = "Touchable Surface with Ripple",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(24.dp)
            )
        }

        //Set appropriate semantics for the Surface container
        // Set appropriate semantics for the Surface container example
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable(onClickLabel = "Example surface with accessibility semantics") {
                    // Surface clicked for accessibility!
                }
                .semantics {
                    contentDescription = "Example surface with accessibility semantics"
                    role = androidx.compose.ui.semantics.Role.Button
                },
            color = MaterialTheme.colorScheme.secondaryContainer,
            shadowElevation = 4.dp
        ) {
            Text(
                text = "Accessible Surface (Button Role)",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(24.dp)
            )
        }
        
        //Use Surface to visually separate sections in a form or list
        // Example: Use Surface to visually separate sections in a simulated form
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Personal Info",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Name: Azharul Islam",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Email: azharul.islam@email.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Account Details",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Username: azharul.dev",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Role: Android Developer",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceVariant,
            shadowElevation = 2.dp,
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Preferences",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Theme: Dark",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Notifications: Enabled",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Text(
            "\uD83D\uDD01 Reusability & Composition", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        // Build a reusable AppCardSurface() composable for common styling
        AppCardSurface(
            onClick = { /* Handle click */ },
            contentDescription = "Example surface with accessibility semantics",
            role = Role.Button
        ) {
            Text(
                text = "Accessible Surface (Button Role)",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(24.dp)
            )
        }


            val avatarPainter = painterResource(id = R.drawable.ic_360)

            UserProfileCard(
                name = "Azharul Islam",
                avatarImage = avatarPainter,
                onFollowClick = {
                    // Handle follow action
                }
            )

            SurfaceSection(
                title = {
                    Text(
                        text = "User Info",
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_360),
                            contentDescription = "User Avatar",
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Azharul Islam", style = MaterialTheme.typography.bodyLarge)
                            Text("Senior Android Developer", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            )



    }
}