package com.klekchyan.harrypottermultiplatform.presentation.character.models

data class CharacterScreenState(
    val character: com.klekchyan.harrypottermultiplatform.domain.entity.Character?,
    val isLoading: Boolean,
    val error: String?
)