package com.jetbrains.kmpapp

import com.jetbrains.kmpapp.data.MuseumRepository
import com.jetbrains.kmpapp.data.auction.AuctionListRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinDependencies : KoinComponent {
    val museumRepository: MuseumRepository by inject()
    val auctionRepository: AuctionListRepository by inject()
}
