package com.klekchyan.harrypottermultiplatform.presentation.screens.main.models

data class MainScreenState(
    val characters: List<com.klekchyan.harrypottermultiplatform.domain.entity.Character> = emptyList(),
    val charactersType: CharactersType = CharactersType.All,
    val isLoading: Boolean = false,
    val error: String? = null
)

enum class CharactersType(val title: String) {
    All("All"),
    Students("Students"),
    Staff("Staff")
}