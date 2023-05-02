package com.klekchyan.harrypottermultiplatform.platform

import com.klekchyan.harrypottermultiplatform.di.*
import com.klekchyan.harrypottermultiplatform.di.networkModule
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
                    domainModule,
                    presentationModule
                )
            }.direct
        )
    }
}