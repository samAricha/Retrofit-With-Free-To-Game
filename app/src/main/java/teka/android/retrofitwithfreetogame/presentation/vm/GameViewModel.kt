package teka.android.retrofitwithfreetogame.presentation.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import teka.android.retrofitwithfreetogame.domain.GetGameByIdUseCase
import teka.android.retrofitwithfreetogame.domain.GetGamesUseCase
import teka.android.retrofitwithfreetogame.domain.items.GameItem
import teka.android.retrofitwithfreetogame.domain.items.SpecificGameItem
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(

    private val getGamesUseCase: GetGamesUseCase,
    private val getGameByIdUseCase: GetGameByIdUseCase

    ): ViewModel() {

    private val _games = MutableLiveData<List<GameItem>>()
    val games : LiveData<List<GameItem>> get() = _games

    private val _game = MutableLiveData<SpecificGameItem>()
    val game: LiveData<SpecificGameItem> get() =  _game

    init {
        getGames()
    }

    private fun getGames() {

        viewModelScope.launch {
            try {
                val games = getGamesUseCase()
                _games.value = games

            }catch (_:Exception){}
        }

    }

    fun getGameById(id: Int) {

        viewModelScope.launch {

            try {

                val game = getGameByIdUseCase(id)
                _game.value = game

            }catch (_:Exception){}

        }

    }


}