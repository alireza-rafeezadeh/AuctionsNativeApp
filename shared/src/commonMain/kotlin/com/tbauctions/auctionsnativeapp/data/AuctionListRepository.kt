package com.tbauctions.auctionsnativeapp.data

import kotlinx.coroutines.flow.Flow

interface AuctionListRepository {
    fun getAuctionList() : Flow<List<AuctionModelItem>>
}