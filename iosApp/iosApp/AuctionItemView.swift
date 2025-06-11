//
//  AuctionItemView.swift
//  iosApp
//
//  Created by Alireza Rafeizadeh on 2025-06-09.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUICore
import SwiftUI
import Shared
import Kingfisher



struct AuctionItemView: View {
    let item: AuctionModelItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            if let url = URL(string: item.image?.thumbUrl ?? "") {
//                AsyncImage(url: url) { phase in
//                    switch phase {
//                    case .empty:
//                        ProgressView()
//                            .frame(height: 200)
//                    case .success(let image):
//                        image
//                            .resizable()
//                            .aspectRatio(contentMode: .fill)
//                            .frame(height: 200)
//                            .clipped()
//                    case .failure:
//                        Color.gray.frame(height: 200)
//                    @unknown default:
//                        EmptyView()
//                    }
//                }
                
                KFImage(URL(string: item.image?.thumbUrl ?? ""))
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
            }

            Text(item.name)
                .font(.headline)

            Text("Current Bid: \(item.currentBid) SEK")
                .font(.subheadline)
                .foregroundColor(.blue)
            
            Text("Ends: \(item.endDate)")
            
        

            Text("Location: \(item.municipalityName)")
                .font(.caption)

            if let make = item.make {
                Text("Make: \(make)")
                    .font(.caption)
            }

//            if let description = item.description {
//            Text("Description: \(item.description)")
//                    .font(.caption)
//                    .lineLimit(3)
            
            // TODO: Why does this print the whole object?
//            Text("Description: \(item.description)")


            Text("Reserve Price Status: \(item.reservePriceStatus.replacingOccurrences(of: "_", with: " ").lowercased())")
                .font(.caption)
                .foregroundColor(colorForReserveStatus(item.reservePriceStatus))
        }
        .padding()
        .background(RoundedRectangle(cornerRadius: 12).stroke(Color.gray.opacity(0.2)))
    }

    private func colorForReserveStatus(_ status: String) -> Color {
        switch status {
        case "NOTREACHED": return .red
        case "REACHED": return .green
        default: return .gray
        }
    }
    
    private static var mediumDateFormatter: DateFormatter {
            let formatter = DateFormatter()
            formatter.dateStyle = .medium
            formatter.timeStyle = .medium
            return formatter
        }
}
