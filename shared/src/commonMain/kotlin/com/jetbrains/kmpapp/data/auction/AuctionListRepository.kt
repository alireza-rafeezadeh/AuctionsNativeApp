package com.jetbrains.kmpapp.data.auction

import kotlinx.coroutines.flow.Flow

interface AuctionListRepository {
    fun getAuctionList() : Flow<List<AuctionModelItem>>
}