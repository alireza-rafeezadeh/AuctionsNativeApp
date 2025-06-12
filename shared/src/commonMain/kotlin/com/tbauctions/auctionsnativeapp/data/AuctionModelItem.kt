package com.tbauctions.auctionsnativeapp.data

import kotlinx.serialization.Serializable

@Serializable
data class ImageUrls(
    val thumbUrl: String,
    val largeUrl: String
)

@Serializable
data class AuctionModelItem(
    val id: Int,
    val name: String,
    val make: String? = null,
    val description: String? = null,
    val currentBid: Int,
    val endDate: String,
    val reservePriceStatus: String,
    val municipalityName: String,
    val image: ImageUrls? = null,
    val categoryLevel1: Int,
    val categoryLevel2: Int,
    val categoryLevel3: Int? = null
)