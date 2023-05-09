package teka.android.retrofitwithfreetogame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import teka.android.retrofitwithfreetogame.presentation.vm.GameViewModel
import teka.android.retrofitwithfreetogame.utils.Constants.Screens.DETAIL_SCREEN
import teka.android.retrofitwithfreetogame.utils.Constants.Screens.HOME_SCREEN

sealed class Screens(val route: String){

    object Home : Screens(route = HOME_SCREEN)
    object Detail : Screens(route = DETAIL_SCREEN)

}

@Composable
fun setupNavHost(navController: NavHostController, gameViewModel: GameViewModel){

    NavHost(navController = navController, startDestination = Screens.Home.route){

    }

}

