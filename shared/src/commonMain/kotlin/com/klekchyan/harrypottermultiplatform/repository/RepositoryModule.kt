package com.klekchyan.harrypottermultiplatform.repository

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val repositoryModule = DI.Module("repositoryModule") {
    bindSingleton<HarryPotterRepository> {
        HarryPotterRepositoryImpl(database = instance(), api = instance())
    }
}