package com.tbauctions.auctionsnativeapp.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.rememberAsyncImagePainter
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel
import com.tbauctions.auctionsnativeapp.theme.Dimens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuctionDetailScreen(
    auctionViewModel: AuctionListViewModel,
    auctionId: Int,
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Auction Listings") })
        }
    ) {

        val auctionList by auctionViewModel.auctionListUIState.collectAsStateWithLifecycle()

        if (auctionList.auctionList.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(Dimens.PaddingMedium)
            ) {
                val item = auctionList.auctionList.firstOrNull { it.id == auctionId }

                item?.image?.largeUrl?.let { url ->
                    Image(
                        painter = rememberAsyncImagePainter(url),
                        contentDescription = "Image of ${item.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Dimens.CardImageHeight),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(Dimens.PaddingMedium))
                }

                Text(
                    "Name: ${auctionList.auctionList[0].name}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text("Make: ${item?.make ?: "Unknown"}", style = MaterialTheme.typography.bodyMedium)
                Text("Description: ${item?.description ?: "No description"}", style = MaterialTheme.typography.bodyMedium)
                Text("Current Bid: $${item?.currentBid}", style = MaterialTheme.typography.bodyMedium)
                Text("End Date: ${item?.endDate}", style = MaterialTheme.typography.bodyMedium)
                Text("Reserve Status: ${item?.reservePriceStatus}", style = MaterialTheme.typography.bodyMedium)
                Text("Municipality: ${item?.municipalityName}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
                Text("Category L1: ${item?.categoryLevel1}", style = MaterialTheme.typography.bodySmall)
                Text("Category L2: ${item?.categoryLevel2}", style = MaterialTheme.typography.bodySmall)
                Text("Category L3: ${item?.categoryLevel3 ?: "N/A"}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}