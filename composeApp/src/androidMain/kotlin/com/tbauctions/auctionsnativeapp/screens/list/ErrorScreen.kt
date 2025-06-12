package com.tbauctions.auctionsnativeapp.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.tbauctions.auctionsnativeapp.theme.Dimens.PaddingLarge
import com.tbauctions.auctionsnativeapp.theme.Dimens.PaddingMedium
import com.tbauctions.auctionsnativeapp.theme.Symbols

@Composable
fun ErrorScreen(
    errorMessage: String,
    onRetry: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingMedium),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = Symbols.warningSymbol,
                style = MaterialTheme.typography.displayMedium,
                color = Color.Red,
                modifier = Modifier.padding(bottom = PaddingMedium)
            )

            Text(
                text = errorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            onRetry?.let {
                Spacer(modifier = Modifier.height(PaddingLarge))
                Button(onClick = it) {
                    Text("Retry")
                }
            }
        }
    }
}