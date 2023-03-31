package com.klekchyan.harrypottermultiplatform.di

import com.klekchyan.harrypottermultiplatform.data.repository.HarryPotterRepositoryImpl
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val domainModule = DI.Module("repositoryModule") {
    bindSingleton<HarryPotterRepository> {
        HarryPotterRepositoryImpl(database = instance(), api = instance())
    }
}