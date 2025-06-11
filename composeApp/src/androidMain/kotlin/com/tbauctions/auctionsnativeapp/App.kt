package com.tbauctions.auctionsnativeapp

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
import com.tbauctions.auctionsnativeapp.screens.list.AuctionListScreen
import com.tbauctions.auctionsnativeapp.screens.AuctionListViewModel
import com.tbauctions.auctionsnativeapp.screens.details.AuctionDetailScreen
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
object AuctionListDestination

@Serializable
data class AuctionDetailDestination(val objectId: Int)


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        val auctionViewModel: AuctionListViewModel = koinViewModel()
        val navController = rememberNavController()

        Surface {
            NavHost(navController = navController, startDestination = AuctionListDestination) {
                composable<AuctionListDestination> {

                    AuctionListScreen(auctionViewModel, navigateToDetails = { objectId ->
                        navController.navigate(AuctionDetailDestination(objectId))
                    })
                }

                composable<AuctionDetailDestination> { backStackEntry ->
                    AuctionDetailScreen(auctionViewModel,
                        objectId = backStackEntry.toRoute<AuctionDetailDestination>().objectId,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
//                composable<DetailDestination> { backStackEntry ->
//                    DetailScreen(
//                        objectId = backStackEntry.toRoute<DetailDestination>().objectId,
//                        navigateBack = {
//                            navController.popBackStack()
//                        }
//                    )
//                }
            }
        }
    }
}
