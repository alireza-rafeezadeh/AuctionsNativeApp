//
//  AuctionsDetailsVuew.swift
//  iosApp
//
//  Created by Alireza Rafeizadeh on 2025-06-11.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Shared
import KMPNativeCoroutinesAsync
import KMPObservableViewModelSwiftUI
import Kingfisher


struct AuctionDetailView: View {

//    let objectId: Int32
//    @StateViewModel
//    var viewModel = AuctionListViewModel(
//        auctionListRepository: KoinDependencies().auctionRepository
//    )

    var item: AuctionModelItem?
//    ? {
//        viewModel.auctionList.first { $0.id == objectId }
//    }

    var body: some View {
        NavigationView {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    if let item = item {
//                        AuctionImageView(imageUrl: item.image.largeUrl)
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
                        
                        
//                        AuctionMainDetailsView(item: item)
                        
                        
                        VStack(alignment: .leading, spacing: 8) {
                                    Text("Name: \(item.name)")
                                        .font(.title2)
                                        .fontWeight(.bold)

                                    Text("Make: \(item.make ?? "Unknown")")
                                    Text("Description: \(item.description ?? "No description")")
                                    Text("Current Bid: $\(item.currentBid)")
                                    Text("End Date: \(item.endDate)")
                                    Text("Reserve Status: \(item.reservePriceStatus)")
                                    Text("Municipality: \(item.municipalityName)")
                                }
                                .font(.body)

                        Divider().padding(.vertical, 8)

//                        AuctionCategoryView(item: item)
                    }
                }
                .padding()
            }
            .navigationTitle("Auction Listings")
        }
    }
}

struct AuctionDetailView_Previews: PreviewProvider {
    static var previews: some View {
//        AuctionDetailView(auctionList: <#[AuctionModelItem]#>, objectId: 2)
    }
}
