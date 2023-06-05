package com.klekchyan.harrypottermultiplatform.domain.entity

import androidx.compose.runtime.Stable

@Stable
data class Character(
    val id: String,
    val name: String,
//    val alternateName: List<String>,
    val species: String,
//    val gender: String,
//    val house: String,
//    val dateOfBirth: String?,
//    val yearOfBirth: Int?,
//    val wizard: Boolean,
//    val ancestry: String,
//    val eyeColour: String,
//    val hairColour: String,
    val wand: Wand?,
//    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
//    val actor: String,
//    val alternateActors: List<String>,
//    val alive: Boolean,
//    val image: String
)

@Stable
data class Wand(
    val wood: String,
    val core: String,
    val length: Double?
)
