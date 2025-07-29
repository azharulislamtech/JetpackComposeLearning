package com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppDimens
import com.me.compose.feature.eight_reusables.DesignSystemSample.ui.designsystem.tokens.AppElevation

@Composable
fun AppCard(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimens.defaultPadding),
        elevation = CardDefaults.cardElevation(AppElevation.low),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(AppDimens.defaultPadding)) {
            content()
        }
    }
}
