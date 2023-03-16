package com.klekchyan.harrypottermultiplatform.network.entity

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CharacterApiEntity(
    val id: String,
    val name: String,
//    @SerialName("alternate_names")
//    val alternateNames: List<String>,
    val species: String,
//    val gender: String,
//    val house: String,
//    val dateOfBirth: String? = null,
//    val yearOfBirth: Int? = null,
//    val wizard: Boolean,
//    val ancestry: String,
//    val eyeColour: String,
//    val hairColour: String,
//    val wand: WandApiEntity,
//    val patronus: String,
//    val hogwartsStudent: Boolean,
//    val hogwartsStaff: Boolean,
//    val actor: String,
//    @SerialName("alternate_actors")
//    val alternateActors: List<String>,
//    val alive: Boolean,
//    val image: String
)

@kotlinx.serialization.Serializable
data class WandApiEntity(
    val wood: String,
    val core: String,
    val length: Double? = null
)
