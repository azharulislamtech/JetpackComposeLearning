package com.me.compose.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun RemoteImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(8.dp),
    contentScale: ContentScale = ContentScale.Crop
) {
    val painter = rememberAsyncImagePainter(imageUrl)
    val isLoading = painter.state is AsyncImagePainter.State.Loading

    Image(
        painter = painter,
        contentDescription = "Remote image",
        modifier = modifier
            .clip(shape)
            .placeholder(
                visible = isLoading,
                shape = shape,
                highlight = PlaceholderHighlight.shimmer()
            ),
        contentScale = contentScale
    )
}
