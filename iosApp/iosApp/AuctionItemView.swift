import SwiftUICore
import SwiftUI
import Shared
import Kingfisher



struct AuctionItemView: View {
    let item: AuctionModelItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            if URL(string: item.image?.thumbUrl ?? "") != nil {
                
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


struct AuctionItemView_Previews: PreviewProvider {
    static var previews: some View {
        let sampleItem = AuctionModelItem(
            id: 101,
            name: "Excavator ZX200",
            make: "Hitachi",
            description: "A powerful excavator, ideal for heavy construction work.",
            currentBid: 150000,
            endDate: "2025-12-31T23:59:00Z",
            reservePriceStatus: "REACHED",
            municipalityName: "Gothenburg",
            image: ImageUrls(
                thumbUrl: "https://via.placeholder.com/300x200",
                largeUrl: "https://via.placeholder.com/600x400"
            ),
            categoryLevel1: 1,
            categoryLevel2: 2,
            categoryLevel3: nil
        )

        AuctionItemView(item: sampleItem)
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
