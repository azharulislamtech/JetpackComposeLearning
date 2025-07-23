package com.me.compose.feature.three_UserInputPlayground.presentation.switchCheckboxSlider.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MusicPreferences(selectedGenres: Set<String>, onGenreToggle: (String) -> Unit) {
    val genres = listOf("Rock", "Jazz", "Pop", "Classical")

    Column {
        Text("Select your favorite genres:")
        genres.forEach { genre ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = genre in selectedGenres,
                    onCheckedChange = { onGenreToggle(genre) }
                )
                Spacer(Modifier.width(8.dp))
                Text(genre)
            }
        }
    }
}
