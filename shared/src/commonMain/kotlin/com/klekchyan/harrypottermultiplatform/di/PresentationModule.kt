package com.klekchyan.harrypottermultiplatform.di

import com.klekchyan.harrypottermultiplatform.presentation.screens.character.CharacterScreenViewModel
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.MainScreenViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val presentationModule = DI.Module("presentation") {
    bindProvider { MainScreenViewModel(instance()) }
    bindProvider { CharacterScreenViewModel(instance()) }
}