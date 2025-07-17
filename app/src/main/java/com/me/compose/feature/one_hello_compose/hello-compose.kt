package com.me.compose.feature.one_hello_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateText(name: String) {
    Box (modifier = Modifier.padding(30.dp), contentAlignment = Alignment.Center){
        Text(

            "Assalaamu Alaikum $name",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 2.sp
            ),
            color = MaterialTheme.colorScheme.tertiary,

        )
    }

}