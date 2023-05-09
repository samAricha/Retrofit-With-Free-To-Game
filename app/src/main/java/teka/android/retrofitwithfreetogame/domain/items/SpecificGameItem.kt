package teka.android.retrofitwithfreetogame.domain.items

import teka.android.retrofitwithfreetogame.data.remote.model.SpecificGameModel

data class SpecificGameItem (

    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,

)

fun SpecificGameModel.toSpecificGameItem() = SpecificGameItem(id, description, thumbnail, title)