package com.me.compose.feature.seven_mediacoil.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomerScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        items(10) { index ->
            Text("Customer #$index", modifier = Modifier.padding(8.dp))
        }
    }
}
