package teka.android.retrofitwithfreetogame.data.repositories

import teka.android.retrofitwithfreetogame.data.remote.GameService
import teka.android.retrofitwithfreetogame.domain.items.GameItem
import teka.android.retrofitwithfreetogame.domain.items.toGameItem
import javax.inject.Inject

class GameRepository @Inject constructor(private val gameService: GameService) {

    suspend fun getGames(): List<GameItem> {

        return gameService.getGames().map {
            it.toGameItem()
        }
    }

}