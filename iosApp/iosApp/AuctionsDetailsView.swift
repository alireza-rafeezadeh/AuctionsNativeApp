import SwiftUI
import Shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI
import Kingfisher


struct AuctionDetailView: View {

    var item: AuctionModelItem?

    var body: some View {
        NavigationView {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    if let item = item {
                        KFImage(URL(string: item.image?.largeUrl ?? ""))
                            .placeholder {
                                ProgressView().frame(height: 200)
                            }
                            .onFailure { error in
                                print("Failed to load image: \(error)")
                            }
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .frame(height: 200)
                            .clipped()
                        
                        VStack(alignment: .leading, spacing: 8) {
                                    Text("Name: \(item.name)")
                                        .font(.title2)
                                        .fontWeight(.bold)

                                    Text("Make: \(item.make ?? "Unknown")")
                                    Text("Current Bid: $\(item.currentBid)")
                                    Text("End Date: \(item.endDate)")
                                    Text("Reserve Status: \(item.reservePriceStatus)")
                                    Text("Municipality: \(item.municipalityName)")
                                }
                                .font(.body)
                        Divider().padding(.vertical, 8)
                    }
                }
                .padding()
            }
        }
    }
}

struct AuctionDetailView_Previews: PreviewProvider {
    static var previews: some View {
        let sampleItem = AuctionModelItem(
            id: 1,
            name: "Vintage Car",
            make: "Ford",
            description: "A classic 1965 Ford Mustang in excellent condition.",
            currentBid: 25000,
            endDate: "2025-12-01",
            reservePriceStatus: "Met",
            municipalityName: "Springfield",
            image: ImageUrls(
                thumbUrl: "https://via.placeholder.com/150",
                largeUrl: "https://via.placeholder.com/600x400"
            ),
            categoryLevel1: 10,
            categoryLevel2: 20,
            categoryLevel3: 30
        )

        AuctionDetailView(item: sampleItem)
    }
}
