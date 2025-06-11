package com.tbauctions.auctionsnativeapp.data

import kotlinx.serialization.Serializable

// If you decide to use kotlinx-datetime for endDate directly:
// import kotlinx.datetime.Instant

// Data class for the nested 'image' object
@Serializable
data class ImageUrls(
    val thumbUrl: String,
    val largeUrl: String
)

// Data class for a single auction item
@Serializable
data class AuctionModelItem(
    val id: Int,
    val name: String,
    val make: String? = null, // Can be missing, so nullable with default null
    val description: String? = null, // Can be missing, so nullable with default null
    val currentBid: Int,
    val endDate: String, // Keep as String for direct JSON parsing
    val reservePriceStatus: String,
    val municipalityName: String,
    val image: ImageUrls? = null, // The image object can be missing/null
    val categoryLevel1: Int,
    val categoryLevel2: Int,
    val categoryLevel3: Int? = null // Can be missing, so nullable with default null
)