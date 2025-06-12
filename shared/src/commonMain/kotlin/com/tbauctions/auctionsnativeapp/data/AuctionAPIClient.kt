package com.tbauctions.auctionsnativeapp.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import kotlin.coroutines.cancellation.CancellationException

class AuctionAPIClient(private val client: HttpClient) : AuctionAPI {

    override suspend fun getData(): List<AuctionModelItem> {
        return try {
            client.get("${Urls.BASE_URL}${ENDPOINTS.PRODUCTS}") {
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