package com.jetbrains.kmpapp.screens.auctionlist

import com.jetbrains.kmpapp.data.auction.AuctionListRepository
import com.jetbrains.kmpapp.data.auction.AuctionModelItem
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class AuctionListViewModel(auctionListRepository: AuctionListRepository) : ViewModel() {
    @NativeCoroutinesState
    val auctionList: StateFlow<List<AuctionModelItem>> =
        auctionListRepository.getAuctionList()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
}