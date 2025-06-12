package com.tbauctions.auctionsnativeapp.screens.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tbauctions.auctionsnativeapp.data.AuctionListUIState
import com.tbauctions.auctionsnativeapp.theme.Dimens.PaddingExtraSmall
import com.tbauctions.auctionsnativeapp.theme.Dimens.PaddingSmall


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuctionList(
    auctionListUIState: AuctionListUIState,
    navigateToDetails: (objectId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text ="Auction Listings") })
        }
    ) { paddingValues ->

        if (auctionListUIState.isLoading) {
            LoadingPage()
        } else {
            if (auctionListUIState.errorMessage == null) {
                if (auctionListUIState.auctionList.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(horizontal = PaddingSmall, vertical = PaddingExtraSmall),
                        verticalArrangement = Arrangement.spacedBy(PaddingSmall)
                    ) {
                        items(auctionListUIState.auctionList) { item ->
                            AuctionListItem(item = item, navigateToDetails)
                        }
                    }
                } else {
                    EmptyScreen()
                }
            }
            auctionListUIState.errorMessage?.let { error ->
                if (error.isNotEmpty()) {
                    ErrorScreen(error, {
                        // TODO: retry button
                    })
                }
            }

        }
    }
}