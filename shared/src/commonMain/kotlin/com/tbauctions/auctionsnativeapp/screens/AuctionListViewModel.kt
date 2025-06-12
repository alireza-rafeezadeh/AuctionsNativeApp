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
                    errorMessage = null,
                    auctionList = response
                )
            }.onStart {
                AuctionListUIState(
                    isLoading = true,
                )
            }.catch { error ->
                AuctionListUIState(
                    isLoading = false,
                    errorMessage = error.message,
                )
            }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                AuctionListUIState()
            )


    //    New stuff:
    /*private val _auctionListUIState = MutableStateFlow(viewModelScope, AuctionListUIState())

    @NativeCoroutinesState
    val auctionListUIState: StateFlow<AuctionListUIState> = _auctionListUIState.asStateFlow()

    init {
        getAuctions()
        print("gotcalled_tag")
    }

    fun getAuctions() {
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
            }.collect { result ->
                _auctionListUIState.update {
                    AuctionListUIState(
                        isLoading = false,
                        errorMessage = null,
                        auctionList = result
                    )
                }
            }
        }
    }*/
}