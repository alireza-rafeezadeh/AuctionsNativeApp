package com.tbauctions.auctionsnativeapp.screens

import com.tbauctions.auctionsnativeapp.data.AuctionListUIState
import com.tbauctions.auctionsnativeapp.data.AuctionListRepository
import com.tbauctions.auctionsnativeapp.data.AuctionModelItem
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import com.rickclephas.kmp.observableviewmodel.stateIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update

class AuctionListViewModel(auctionListRepository: AuctionListRepository) : ViewModel() {
    @NativeCoroutinesState
    val auctionList: StateFlow<List<AuctionModelItem>> =
        auctionListRepository.getAuctionList()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )



//    New stuff:
    private val _auctionListUIState = MutableStateFlow(AuctionListUIState())
    val auctionListUIState: StateFlow<AuctionListUIState> = _auctionListUIState

    init {
        _auctionListUIState.update {
            AuctionListUIState(
                isLoading = true,
            )
        }
        viewModelScope.launch {
            auctionListRepository.getAuctionList().catch { error ->
                AuctionListUIState(
                    isLoading = false,
                    errorMessage = error.message,
                )
            }.collect{ result ->
                _auctionListUIState.update {
                    AuctionListUIState(
                        isLoading = false,
                        errorMessage = null,
                        auctionList = result
                    )
                }
            }
        }
    }
}