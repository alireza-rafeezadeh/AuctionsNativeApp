package com.jetbrains.kmpapp.data.auction

import com.jetbrains.kmpapp.data.Image

data class AuctionModelItem(
    val categoryLevel1: Int,
    val categoryLevel2: Int,
    val categoryLevel3: Int,
    val currentBid: Int,
    val description: String,
    val endDate: String,
    val id: Int,
    val image: Image,
    val make: String,
    val model: String,
    val municipalityName: String,
    val name: String,
    val preamble: String,
    val reservePriceStatus: String
)