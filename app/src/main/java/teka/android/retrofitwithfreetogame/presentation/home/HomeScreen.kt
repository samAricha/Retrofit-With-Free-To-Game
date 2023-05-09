package teka.android.retrofitwithfreetogame.presentation.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import teka.android.retrofitwithfreetogame.domain.items.GameItem
import teka.android.retrofitwithfreetogame.navigation.Screens
import teka.android.retrofitwithfreetogame.presentation.vm.GameViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(

    gameViewModel: GameViewModel,
    navController: NavController

) {

//    val homeViewModel: HomeViewModel = viewModel()
//    val games by homeViewModel.games.collectAsState()

    val games = gameViewModel.games.observeAsState(listOf()).value

    Scaffold(
        topBar = {
            TopAppBar(
                
                title = {
                    Text(text = "Free Games", fontWeight = FontWeight.Bold)
                }
                
            )
        }
    ) {

        LazyColumn {

            items(games) { game: GameItem ->

                GameCard(game = game, navController = navController)

            }

        }

    }



    
}

@Composable
fun GameCard(game: GameItem, navController: NavController) {

    val image = rememberImagePainter(data = game.thumbnail)

    Card(
        elevation = 7.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 7.dp, bottom = 7.dp, start = 14.dp, end = 14.dp)
            .fillMaxSize()
            .clickable{
                navController.navigate(Screens.Detail.route + "/${game.id}")

            }

    ) {

        Row {
            
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(175.dp)
                    .height(115.dp)
            )
            
            Column(modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterVertically)) {
                
                Text(text = game.title, fontWeight = FontWeight.Bold)
                Text(text = game.short_description, maxLines = 2, overflow = TextOverflow.Ellipsis)
                
            }
            
        }
    }

}
