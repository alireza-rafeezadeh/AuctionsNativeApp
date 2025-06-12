package com.tbauctions.auctionsnativeapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuctionListRepositoryImpl(val auctionAPI: AuctionAPI) : AuctionListRepository {

    override fun getAuctionList(): Flow<List<AuctionModelItem>> = flow {
        val data = auctionAPI.getData() // Could cache data to a local datasource here as well
        emit(data)
    }.flowOn(Dispatchers.IO)
}