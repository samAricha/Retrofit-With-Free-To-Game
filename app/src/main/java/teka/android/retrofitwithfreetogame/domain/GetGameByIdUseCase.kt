package teka.android.retrofitwithfreetogame.domain

import teka.android.retrofitwithfreetogame.data.repositories.GameRepository
import teka.android.retrofitwithfreetogame.domain.items.SpecificGameItem
import javax.inject.Inject


class GetGameByIdUseCase @Inject constructor(private val gameRepository: GameRepository){

    suspend operator fun invoke(id: Int): SpecificGameItem {

        return gameRepository.getGameById(id)

    }

}