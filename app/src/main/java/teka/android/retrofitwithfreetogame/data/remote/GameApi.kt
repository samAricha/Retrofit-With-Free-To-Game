package teka.android.retrofitwithfreetogame.data.remote

import retrofit2.Response
import retrofit2.http.GET
import teka.android.retrofitwithfreetogame.data.remote.model.GameModel
import teka.android.retrofitwithfreetogame.utils.Constants.Companion.GAMES_ENDPOINT


interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames(): Response<List<GameModel>>
}