package com.tbauctions.auctionsnativeapp.data

import platform.Foundation.NSBundle

actual val AuctionsApiKey: String by lazy {
    NSBundle.mainBundle.objectForInfoDictionaryKey("AUCTIONS_API_KEY") as? String
        ?: error("AUCTIONS_API_KEY not found in Info.plist")
}