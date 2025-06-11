package com.jetbrains.kmpapp

import com.jetbrains.kmpapp.data.auction.AuctionListRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val auctionRepository: AuctionListRepository by inject()
}
