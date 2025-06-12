package com.tbauctions.auctionsnativeapp.data


interface AuctionAPI {
    suspend fun getData(): List<AuctionModelItem>
}