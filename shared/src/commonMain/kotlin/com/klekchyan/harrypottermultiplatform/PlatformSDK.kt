package com.klekchyan.harrypottermultiplatform

import com.klekchyan.harrypottermultiplatform.database.databaseModule
import com.klekchyan.harrypottermultiplatform.di.Inject
import com.klekchyan.harrypottermultiplatform.network.networkModule
import com.klekchyan.harrypottermultiplatform.platform.PlatformConfiguration
import com.klekchyan.harrypottermultiplatform.repository.repositoryModule
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.direct

object PlatformSDK {
    fun init(platformConfiguration: PlatformConfiguration) {

        val platformModule = DI.Module(
            name = "platformModule",
            init = {
                bindSingleton<PlatformConfiguration> { platformConfiguration }
            }
        )

         Inject.createDependencies(
            DI {
                importAll(
                    platformModule,
                    networkModule,
                    databaseModule,
                    repositoryModule
                )
            }.direct
        )
    }
}