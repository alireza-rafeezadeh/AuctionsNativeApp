package com.tbauctions.auctionsnativeapp.data

data class AuctionListUIState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null,
    var auctionList: List<AuctionModelItem> = emptyList()
)