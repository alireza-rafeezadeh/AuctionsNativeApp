import SwiftUI
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI
import Shared

struct AuctionView: View {
    @StateViewModel
    var viewModel = AuctionListViewModel(
        auctionListRepository: KoinDependencies().auctionRepository
    )

//    let columns = [
//        GridItem(.adaptive(minimum: 120), alignment: .top)
//    ]
//
//    var body: some View {
//        ZStack {
//
//                Text("No data available")
//
//        }
//    }


    var body: some View {
        NavigationView {
            ScrollView {
                LazyVStack(spacing: 16) {
//                    let sdfsf = viewModel.auctionListUIState.auctionList
//                    let auctions = viewModel.getAuctions()
                    ForEach(viewModel.auctionListUIState.auctionList, id: \.self) { item in
//                        NavigationLink(destination: AuctionDetailView(objectId: item.id),)
                        NavigationLink(destination: AuctionDetailView(item: item), label: {
                            AuctionItemView(item: item)
                        })
//                        AuctionItemView(item: item)
                    }
                }
                .padding()
            }
            .navigationTitle("Auction Listings")
        }
    }
}
