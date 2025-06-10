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
                    ForEach(viewModel.auctionList, id: \.self) { item in
                        AuctionItemView(item: item)
                    }
                }
                .padding()
            }
            .navigationTitle("Auction Listings")
        }
    }
}
