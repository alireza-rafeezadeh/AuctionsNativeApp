package com.tbauctions.auctionsnativeapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuctionListRepositoryImpl(val auctionAPI: AuctionAPI) : AuctionListRepository {

    override fun getAuctionList(): Flow<List<AuctionModelItem>> = flow {
        // Simulate a network call or database query
        val data = auctionAPI.getData() // This might be a suspend call
        emit(data)

        // If you need continuous updates, you'd have more logic here,
        // like observing a database or polling an API.
        // For example:
        // while (true) {
        //     delay(5000) // Poll every 5 seconds
        //     val updatedData = SomeApiService.fetchAuctionObjects()
        //     emit(updatedData)
        // }
    }.flowOn(Dispatchers.IO)

}