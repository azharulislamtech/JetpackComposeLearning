package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.me.compose.R

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

    }


}