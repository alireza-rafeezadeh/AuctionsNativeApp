package com.tbauctions.auctionsnativeapp.data

import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AuctionListRepositoryImplTest {
    private lateinit var auctionAPI: AuctionAPI
    private lateinit var repository: AuctionListRepositoryImpl

    @Before
    fun setup() {
        auctionAPI = mockk()
        repository = AuctionListRepositoryImpl(auctionAPI)
    }

    @Test
    fun `getAuctionList emits expected auction items`() = runTest {
        val expectedList = listOf(
            AuctionModelItem(
                id = 1,
                name = "Antique Vase",
                make = "Ming Dynasty",
                description = "A rare and valuable vase",
                currentBid = 10000,
                endDate = "2025-12-31T23:59:59Z",
                reservePriceStatus = "MET",
                municipalityName = "Beijing",
                image = ImageUrls(
                    thumbUrl = "https://example.com/thumb.jpg",
                    largeUrl = "https://example.com/large.jpg"
                ),
                categoryLevel1 = 10,
                categoryLevel2 = 101,
                categoryLevel3 = 1011
            )
        )

        coEvery { auctionAPI.getData() } returns expectedList
        val result = repository.getAuctionList().first()
        assertEquals(expectedList, result)
    }
}