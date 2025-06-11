package com.jetbrains.kmpapp.screens.auctionlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jetbrains.kmpapp.ui.theme.Dimens.IconSizeLarge
import com.jetbrains.kmpapp.ui.theme.Dimens.PaddingLarge
import com.jetbrains.kmpapp.ui.theme.Dimens.PaddingMedium

@Composable
fun LoadingPage() {
    Box(
        modifier = Modifier.fillMaxSize().padding(PaddingMedium),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Loading...", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(PaddingLarge))
            CircularProgressIndicator(
                modifier = Modifier.size(IconSizeLarge),
                trackColor = ProgressIndicatorDefaults.circularIndeterminateTrackColor,
            )
        }
    }
}