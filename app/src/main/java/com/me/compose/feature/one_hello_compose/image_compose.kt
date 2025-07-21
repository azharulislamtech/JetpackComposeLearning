package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import com.me.compose.R
import com.me.compose.ui.components.image.UserProfileImage
import com.me.compose.utils.UserProfileImage

@Preview
@Composable
fun CreateImage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "\uD83D\uDCE6 Basic Display", style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )
        Image(
            painter = painterResource(id = R.drawable.ic_360),
            contentDescription = "My Local Drawable"
        )
        // Example using ImageBitmap from a local drawable resource
        val imageBitmap = ImageBitmap.imageResource(id = R.drawable.pumpkin)
        Image(
            bitmap = imageBitmap,
            contentDescription = "My Local Drawable (ImageBitmap)"
        )
        // Display a simple static logo centered on the screen
        Image(
            painter = painterResource(id = R.drawable.ic_360),
            contentDescription = "Logo"
        )
        Text(
            "\uD83C\uDF10 Network Images with Coil",
            style = MaterialTheme.typography.headlineSmall.copy(
                textDecoration = TextDecoration.Underline
            )
        )

        // Display a network image using Coil's AsyncImage
        // Example URL: replace with your own image URL if needed

        // Or use Coil's AsyncImage composable for a simpler approach
        AsyncImage(
            model = "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
            contentDescription = "Remote image using AsyncImage"
        )

        // Show a loading indicator while the image loads using Coil's painter state
        val imageUrl = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
        val painter = rememberAsyncImagePainter(model = imageUrl)
        val painterState = painter.state

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // or any height you need
        ) {
            Image(
                painter = painter,
                contentDescription = "Remote image using AsyncImage",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            if (painterState is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator()
            }
        }
        // Handle image loading failure with an error placeholder
        if (painterState is AsyncImagePainter.State.Error) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                // You can show an error icon or fallback image here
                Text(
                    text = "Failed to load image",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Text(
            "Styling & Presentation",
            style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
        )
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Styled image",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )

        // Circle shape clipped image
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Circle clipped image",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),

            )

        // Rounded corner clipped image
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Rounded corner clipped image",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),

            )

        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Image with border",
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(width = 3.dp, color = Color.Magenta, shape = RoundedCornerShape(12.dp))
        )

        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Circular image with border",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(3.dp, Color.Blue, CircleShape), // Border added
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Rounded image with border",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .border(3.dp, Color.Green, RoundedCornerShape(16.dp)), // Border added
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .padding(24.dp)
                .size(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFFFF3E0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Image with colored background and padding",
                modifier = Modifier.size(60.dp)
            )
        }

        Box(
            modifier = Modifier
                .background(
                    Color.LightGray,
                    shape = RoundedCornerShape(12.dp)
                ) // Background color + shape
                .padding(16.dp) // Outer padding
        ) {
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Image with background and padding",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp)) // Optional clipping
                    .background(Color.White) // Optional inner background
                    .padding(8.dp), // Inner padding
                contentScale = ContentScale.Crop
            )
        }

        Text(
            "\uD83D\uDCD0 Layout & Scaling",
            style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
        )

        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "Layout & scaling",
            modifier = Modifier
                .size(200.dp, 120.dp)
                .background(Color(0xFFE3F2FD), shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        val imageUrl1 = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
        val painter1 = rememberAsyncImagePainter(model = imageUrl1)

        Box(
            modifier = Modifier
                .size(200.dp) // Set desired image size
                .clip(RoundedCornerShape(12.dp)) // Optional clipping
                .background(Color.LightGray),    // Optional background
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter1,
                contentDescription = "Cropped Image",
                contentScale = ContentScale.Crop, // Crop image to fill bounds
                modifier = Modifier.fillMaxSize()
            )
        }

        // Demonstrate different ContentScale options with local drawable
        Text("ContentScale.Fit", style = MaterialTheme.typography.labelLarge)
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "ContentScale.Fit example",
            modifier = Modifier
                .size(180.dp)
                .background(Color(0xFFBBDEFB), RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Fit
        )

        Text("ContentScale.Inside", style = MaterialTheme.typography.labelLarge)
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "ContentScale.Inside example",
            modifier = Modifier
                .size(180.dp)
                .background(Color(0xFFC8E6C9), RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Inside
        )

        Text("ContentScale.FillBounds", style = MaterialTheme.typography.labelLarge)
        Image(
            painter = painterResource(id = R.drawable.pumpkin),
            contentDescription = "ContentScale.FillBounds example",
            modifier = Modifier
                .size(180.dp)
                .background(Color(0xFFFFCDD2), RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .size(180.dp)
                .background(Color(0xFFFFFDE7), shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Pumpkin with overlayed text",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Overlay Text",
                style = MaterialTheme.typography.headlineSmall.copy(color = Color.White),
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(Color(0x88000000), shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }


        val imageUrl2 = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
        val painter2 = rememberAsyncImagePainter(model = imageUrl2)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painter2,
                contentDescription = "Nature image with text overlay",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)) // Optional dark overlay for readability
            )

            Text(
                text = "Explore Nature",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }

        Text(
            " Composition with Other Elements",
            style = MaterialTheme.typography.headlineSmall.copy(textDecoration = TextDecoration.Underline)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Text(
                text = "Username",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(16.dp)),
        ) {
            Column {
                // Image section
                Image(
                    painter = painterResource(id = R.drawable.pumpkin),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )
                // Title & Description
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Delicious Pumpkin",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Try this lovely autumn pumpkin. Grown fresh, ready to spice up your meals with vibrant flavor.",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
                    )
                    // Actions row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { /* TODO: Favorite action */ }) {
                            Text("Favorite")
                        }
                        TextButton(onClick = { /* TODO: Share action */ }) {
                            Text("Share")
                        }
                    }
                }
            }

        }

        val imageUrl4 = "https://images.unsplash.com/photo-1506744038136-46273834b3fb"
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl4),
                    contentDescription = "Nature image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Beautiful Nature",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Text(
                    text = "Explore the wonders of nature with high-resolution photography.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = { /* Handle Read More */ }) {
                        Text("Read More")
                    }
                    Button(onClick = { /* Handle Action */ }) {
                        Text("Explore")
                    }
                }
            }

        }


        //todo: Combine image with a loading shimmer effect (optional advanced)


        val isLoading = painterState is AsyncImagePainter.State.Loading

        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .placeholder(
                    visible = isLoading,
                    color = Color.Gray,
                    highlight = PlaceholderHighlight.shimmer()
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = "Image with shimmer",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        // Preview different image shapes and sizes
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Square image 60x60dp
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Square 60dp",
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFE1F5FE), RoundedCornerShape(4.dp))
                    .border(1.dp, Color.Cyan, RoundedCornerShape(4.dp))
            )
            // Circle image 60x60dp
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Circle 60dp",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Magenta, CircleShape)
            )
            // Rounded corners image 60x60dp
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Rounded 60dp",
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Green, RoundedCornerShape(16.dp))
            )
            // Rectangle image 60x40dp
            Image(
                painter = painterResource(id = R.drawable.pumpkin),
                contentDescription = "Rect 60x40dp",
                modifier = Modifier
                    .size(width = 60.dp, height = 40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
            )
        }

//todo:Build a reusable UserProfileImage() composable
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserProfileImage(
                imageUrl = "https://randomuser.me/api/portraits/men/75.jpg",
                size = 100.dp,
                borderColor = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text("Azharul Islam", style = MaterialTheme.typography.titleMedium)
        }

    }

}