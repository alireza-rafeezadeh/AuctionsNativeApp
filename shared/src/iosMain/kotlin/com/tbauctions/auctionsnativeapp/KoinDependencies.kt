package com.tbauctions.auctionsnativeapp

import com.tbauctions.auctionsnativeapp.data.AuctionListRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val auctionRepository: AuctionListRepository by inject()
}
