package com.me.compose.ui.components.image



import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
fun UserProfileImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    size: Dp = 80.dp,
    borderColor: Color = Color.Gray,
    borderWidth: Dp = 2.dp,
    contentDescription: String? = "User profile image"
) {
    val painter = rememberAsyncImagePainter(model = imageUrl)
    val isLoading = painter.state is AsyncImagePainter.State.Loading

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .border(borderWidth, borderColor, CircleShape)
            .placeholder(
                visible = isLoading,
                shape = CircleShape,
                highlight = PlaceholderHighlight.shimmer(),
                color = Color.LightGray
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
