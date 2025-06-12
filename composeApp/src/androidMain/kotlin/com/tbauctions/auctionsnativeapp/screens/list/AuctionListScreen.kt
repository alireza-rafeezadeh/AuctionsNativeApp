package com.tbauctions.auctionsnativeapp.screens.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AuctionListScreen(
    auctionViewModel: AuctionListViewModel,
    navigateToDetails: (objectId: Int) -> Unit
) {
    val auctionList by auctionViewModel.auctionListUIState.collectAsStateWithLifecycle()
    AuctionList(auctionList, navigateToDetails)
}