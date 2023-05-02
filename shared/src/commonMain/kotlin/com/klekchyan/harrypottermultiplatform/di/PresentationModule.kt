package com.klekchyan.harrypottermultiplatform.di

import com.klekchyan.harrypottermultiplatform.presentation.character.CharacterScreenViewModel
import com.klekchyan.harrypottermultiplatform.presentation.main.MainScreenViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val presentationModule = DI.Module("presentation") {
    bindProvider { MainScreenViewModel(instance()) }
    bindProvider { CharacterScreenViewModel(instance()) }
}