package com.tbauctions.auctionsnativeapp.screens.app

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel
import com.tbauctions.auctionsnativeapp.screens.app.Destinations.AuctionDetail
import com.tbauctions.auctionsnativeapp.screens.app.Destinations.AuctionList
import com.tbauctions.auctionsnativeapp.screens.details.AuctionDetailScreen
import com.tbauctions.auctionsnativeapp.screens.list.AuctionListScreen
import org.koin.compose.viewmodel.koinViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        val auctionViewModel: AuctionListViewModel = koinViewModel()
        val navController = rememberNavController()

        Surface {
            NavHost(navController = navController, startDestination = AuctionList) {
                composable<AuctionList> {
                    AuctionListScreen(auctionViewModel, navigateToDetails = { objectId ->
                        navController.navigate(AuctionDetail(objectId))
                    })
                }

                composable<AuctionDetail> { backStackEntry ->
                    AuctionDetailScreen(auctionViewModel,
                        objectId = backStackEntry.toRoute<AuctionDetail>().objectId,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
