import com.jetbrains.kmpapp.data.auction.AuctionModelItem

data class AuctionListUIState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    var auctionList: List<AuctionModelItem> = emptyList()
)