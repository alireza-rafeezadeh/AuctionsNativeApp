package com.tbauctions.auctionsnativeapp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import kotlin.coroutines.cancellation.CancellationException


object test {
    val url = "https://app.klaravik.dev/dev-test-api/products"

}


interface AuctionAPI {
    suspend fun getData(): List<AuctionModelItem>
}

class KtorAuctionAPI(private val client: HttpClient) : AuctionAPI {
    companion object {
        private const val API_URL =
            "https://app.klaravik.dev/dev-test-api/products"
    }

    override suspend fun getData(): List<AuctionModelItem> {
        return try {
            client.get(API_URL) {
                headers {
                    append("X-API-Key", AuctionsApiKey)
                }
            }.body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            emptyList()
        }
        }
}