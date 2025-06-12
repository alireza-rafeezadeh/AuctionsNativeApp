import SwiftUI
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI
import Shared

struct AuctionView: View {
    
    @StateViewModel
    var viewModel = AuctionListViewModel(
        auctionListRepository: KoinDependencies().auctionRepository
    )

    var body: some View {
        NavigationView {
            ScrollView {
                LazyVStack(spacing: 16) {
                    if (viewModel.auctionListUIState.isLoading) {
                        LoadingView()
                    } else {
                        if (viewModel.auctionListUIState.errorMessage == nil) {
                            if (viewModel.auctionListUIState.auctionList.isEmpty) {
                                EmptyView()
                            } else {
                            ForEach(viewModel.auctionListUIState.auctionList, id: \.self) { item in

                                NavigationLink(destination: AuctionDetailView(item: item), label: {
                                    AuctionItemView(item: item)
                                })
                            }
                            }
                        } else {
                            ErrorView(errorMessage: viewModel.auctionListUIState.errorMessage ?? "Error occurred")
                        }
                    }
                }
                .padding()
            }
            .navigationTitle("Auction Listings")
        }
    }
}






