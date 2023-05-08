package teka.android.retrofitwithfreetogame.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.retrofitwithfreetogame.domain.GetGamesUseCase
import teka.android.retrofitwithfreetogame.domain.item.GameItem
import javax.inject.Inject


class HomeViewModel @Inject constructor(
    private val getGamesUseCase: GetGamesUseCase
    ) : ViewModel(){

    private val _games = MutableStateFlow(emptyList<GameItem>())
    val games : StateFlow<List<GameItem>> get() = _games

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {

            try {

                val games = getGamesUseCase()
                _games.value = games

            } catch (_: Exception) {

            }

        }
    }

}