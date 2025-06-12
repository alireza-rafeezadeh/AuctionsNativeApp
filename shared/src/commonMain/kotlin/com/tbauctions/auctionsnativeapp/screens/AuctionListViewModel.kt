package com.tbauctions.auctionsnativeapp.screens

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import com.tbauctions.auctionsnativeapp.data.AuctionListRepository
import com.tbauctions.auctionsnativeapp.data.AuctionListUIState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

class AuctionListViewModel(auctionListRepository: AuctionListRepository) : ViewModel() {

    @NativeCoroutinesState
    val auctionListUIState: StateFlow<AuctionListUIState> =
        auctionListRepository.getAuctionList()
            .map { response ->
                AuctionListUIState(
                    isLoading = false,
                    auctionList = response
                )
            }.onStart {
                AuctionListUIState(
                    isLoading = true,
                )
            }.catch { error ->
                AuctionListUIState(
                    isLoading = false,
                    hasError = true,
                    errorMessage = error.message,
                )
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                AuctionListUIState(isLoading = true)
            )
}