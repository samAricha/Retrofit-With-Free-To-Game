package teka.android.retrofitwithfreetogame.domain

import teka.android.retrofitwithfreetogame.data.repositories.GameRepository
import teka.android.retrofitwithfreetogame.domain.items.GameItem
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private val gameRepository: GameRepository){

    suspend operator fun invoke(): List<GameItem> {

        return gameRepository.getGames().shuffled()

    }

}