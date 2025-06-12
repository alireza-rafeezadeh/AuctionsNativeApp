package com.tbauctions.auctionsnativeapp.screens.app

import android.app.Application
import com.tbauctions.auctionsnativeapp.di.initKoin
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel
import org.koin.dsl.module

class AuctionsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            listOf(
                module {
                    factory { AuctionListViewModel(get()) }
                }
            )
        )
    }
}
