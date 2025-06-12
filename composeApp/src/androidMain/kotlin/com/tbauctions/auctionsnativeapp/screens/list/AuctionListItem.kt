package com.tbauctions.auctionsnativeapp.screens.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.tbauctions.auctionsnativeapp.data.AuctionModelItem
import com.tbauctions.auctionsnativeapp.theme.Dimens
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuctionListItem(item: AuctionModelItem, navigateToDetails: (objectId: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = {
            navigateToDetails(item.id)
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            item.image?.thumbUrl.let { imageUrl ->
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

            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))

            Text(
                text = "Current Bid: ${item.currentBid} SEK", // Assuming SEK based on content
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))

            val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            Text(
                text = "Ends: ${item.endDate.format(formatter)}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))

            Text(
                text = "Location: ${item.municipalityName}",
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))

            item.make.let { make ->
                Text(
                    text = "Make: $make",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))
            }

            item.description.let { description ->
                Text(
                    text = "Description: $description",
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 3 // Limit description to a few lines
                )
                Spacer(modifier = Modifier.height(Dimens.SpacerHeightSmall))
            }

            Text(
                text = "Reserve Price Status: ${item.reservePriceStatus.replace("_", " ").lowercase()}",
                style = MaterialTheme.typography.bodySmall,
                color = when (item.reservePriceStatus) {
                    "NOTREACHED" -> Color.Red
                    "REACHED" -> Color.Green
                    else -> Color.Gray
                }
            )
        }
    }
}