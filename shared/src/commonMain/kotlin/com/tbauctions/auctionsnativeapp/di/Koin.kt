package com.tbauctions.auctionsnativeapp.di

import com.tbauctions.auctionsnativeapp.data.AuctionAPI
import com.tbauctions.auctionsnativeapp.data.AuctionAPIClient
import com.tbauctions.auctionsnativeapp.data.AuctionListRepository
import com.tbauctions.auctionsnativeapp.data.AuctionListRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = ContentType.Any)
            }
        }
    }

    single<AuctionAPI> { AuctionAPIClient(get()) }
    single<AuctionListRepository> { AuctionListRepositoryImpl(get()) }
}


fun initKoin() = initKoin(emptyList())

fun initKoin(extraModules: List<Module>) {
    startKoin {
        modules(
            dataModule,
            *extraModules.toTypedArray(),
        )
    }
}
