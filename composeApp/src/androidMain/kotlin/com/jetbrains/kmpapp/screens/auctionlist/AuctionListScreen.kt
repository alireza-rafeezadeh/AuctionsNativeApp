package com.jetbrains.kmpapp.screens.auctionlist

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.rememberAsyncImagePainter
import com.jetbrains.kmpapp.data.auction.AuctionModelItem
import org.koin.androidx.compose.koinViewModel
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuctionListScreen() {
    val auctionViewModel: AuctionListViewModel = koinViewModel()
    val auctionList by auctionViewModel.auctionList.collectAsStateWithLifecycle()
    Log.i("test_tg", "AuctionListScreen: ${auctionList}")
    AuctionList(auctionList)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuctionList(auctionItems: List<AuctionModelItem>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Auction Listings") })
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 8.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(auctionItems) { item ->
                AuctionListItem(item = item)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuctionListItem(item: AuctionModelItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max), // Allows content to define height
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Auction Image
            item.image.thumbUrl.let { imageUrl ->
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Image of ${item.name}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Auction Name
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Current Bid
            Text(
                text = "Current Bid: ${item.currentBid} SEK", // Assuming SEK based on content
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))

            // End Date
            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            Text(
                text = "Ends: ${item.endDate.format(formatter)}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Municipality
            Text(
                text = "Location: ${item.municipalityName}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Make (if available)
            item.make.let { make ->
                Text(
                    text = "Make: $make",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

            // Description (if available)
            item.description.let { description ->
                Text(
                    text = "Description: $description",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3 // Limit description to a few lines
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

            // Reserve Price Status
            Text(
                text = "Reserve Price Status: ${item.reservePriceStatus.replace("_", " ").lowercase()}",
                style = MaterialTheme.typography.bodySmall,
                color = when (item.reservePriceStatus) {
                    "NOTREACHED" -> Color.Red
                    "REACHED" -> Color.Green // Assuming 'REACHED' as another status
                    else -> Color.Gray
                }
            )
        }
    }
}