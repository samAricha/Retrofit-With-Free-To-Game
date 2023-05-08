package teka.android.retrofitwithfreetogame.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import teka.android.retrofitwithfreetogame.presentation.home.HomeScreen
import teka.android.retrofitwithfreetogame.ui.theme.RetrofitWithFreeToGameTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitWithFreeToGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    HomeScreen()

                }
            }
        }
    }
}

