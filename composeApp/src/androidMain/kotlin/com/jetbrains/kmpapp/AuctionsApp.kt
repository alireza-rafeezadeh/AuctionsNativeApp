package com.jetbrains.kmpapp

import android.app.Application
import com.jetbrains.kmpapp.di.initKoin
import com.jetbrains.kmpapp.screens.auctionlist.AuctionListViewModel
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
