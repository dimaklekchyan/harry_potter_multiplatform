package com.klekchyan.harrypottermultiplatform.presentation.main.models

data class MainViewState(
    val characters: List<com.klekchyan.harrypottermultiplatform.domain.entity.Character>,
    val isLoading: Boolean,
    val error: String?
)