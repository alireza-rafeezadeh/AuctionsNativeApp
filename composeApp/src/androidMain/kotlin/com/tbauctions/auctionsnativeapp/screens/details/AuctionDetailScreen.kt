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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.rememberAsyncImagePainter
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuctionDetailScreen(
    auctionViewModel: AuctionListViewModel,
    objectId: Int,
    navigateBack: () -> Unit
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
                    .padding(16.dp)
            ) {
                val item = auctionList.auctionList.firstOrNull { it.id == objectId }

                item?.image?.largeUrl?.let { url ->
                    Image(
                        painter = rememberAsyncImagePainter(url),
                        contentDescription = "Image of ${item.name}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Text(
                    "Name: ${auctionList.auctionList[0].name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text("Make: ${item?.make ?: "Unknown"}", fontSize = 16.sp)
                Text("Description: ${item?.description ?: "No description"}", fontSize = 16.sp)
                Text("Current Bid: $${item?.currentBid}", fontSize = 16.sp)
                Text("End Date: ${item?.endDate}", fontSize = 16.sp)
                Text("Reserve Status: ${item?.reservePriceStatus}", fontSize = 16.sp)
                Text("Municipality: ${item?.municipalityName}", fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Category L1: ${item?.categoryLevel1}", fontSize = 14.sp)
                Text("Category L2: ${item?.categoryLevel2}", fontSize = 14.sp)
                Text("Category L3: ${item?.categoryLevel3 ?: "N/A"}", fontSize = 14.sp)
            }
        }
    }
}