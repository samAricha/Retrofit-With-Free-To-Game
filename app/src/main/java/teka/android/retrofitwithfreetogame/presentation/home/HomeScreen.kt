package teka.android.retrofitwithfreetogame.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import teka.android.retrofitwithfreetogame.domain.item.GameItem


@Composable
fun HomeScreen() {
    
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val games by homeViewModel.games.collectAsState()

    LazyColumn {

        items(games) { game: GameItem ->

            GameCard(game = game)

        }

    }
    
}

@Composable
fun GameCard(game: GameItem) {


}
