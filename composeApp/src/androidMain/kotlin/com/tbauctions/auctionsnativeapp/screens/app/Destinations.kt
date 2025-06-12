package com.tbauctions.auctionsnativeapp.screens.app

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations {
    @Serializable
    object AuctionList : Destinations()

    @Serializable
    data class AuctionDetail(val objectId: Int) : Destinations()
}