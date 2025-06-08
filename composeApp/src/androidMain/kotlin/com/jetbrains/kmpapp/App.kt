package com.jetbrains.kmpapp

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
import com.jetbrains.kmpapp.screens.auctionlist.AuctionListScreen
import kotlinx.serialization.Serializable

@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = ListDestination) {
                composable<ListDestination> {
//                    ListScreen(navigateToDetails = { objectId ->
//                        navController.navigate(DetailDestination(objectId))
//                    })
                    AuctionListScreen()
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
