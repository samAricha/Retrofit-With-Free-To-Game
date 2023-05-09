package teka.android.retrofitwithfreetogame.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import teka.android.retrofitwithfreetogame.data.remote.model.GameModel
import teka.android.retrofitwithfreetogame.data.remote.model.SpecificGameModel
import teka.android.retrofitwithfreetogame.utils.Constants.Companion.GAMES_ENDPOINT
import teka.android.retrofitwithfreetogame.utils.Constants.Companion.GAME_ID_ENDPOINT


interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>
}