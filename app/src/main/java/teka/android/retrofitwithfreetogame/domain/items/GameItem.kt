package teka.android.retrofitwithfreetogame.domain.items

import teka.android.retrofitwithfreetogame.data.remote.model.GameModel

data class GameItem(

    val id: Int,
    val title: String,
    val thumbnail: String,
    val short_description: String,

)

fun GameModel.toGameItem() = GameItem(id, title, thumbnail, short_description)
