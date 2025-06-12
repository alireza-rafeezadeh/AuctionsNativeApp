import SwiftUI

struct ErrorView: View {
    let errorMessage: String

    var body: some View {
        VStack(spacing: 16) {
            Image(systemName: "exclamationmark.triangle.fill")
                .foregroundColor(.red)
                .font(.system(size: 50))

            Text("Something went wrong")
                .font(.title2)
                .fontWeight(.semibold)

            Text(errorMessage)
                .font(.body)
                .foregroundColor(.gray)
                .multilineTextAlignment(.center)
                .padding(.horizontal)

        }
        .padding()
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color(.systemBackground))
        .ignoresSafeArea()
    }
}

#Preview {
    ErrorView(errorMessage: "Failed to load data from the server. Please check your internet connection and try again.")
}
