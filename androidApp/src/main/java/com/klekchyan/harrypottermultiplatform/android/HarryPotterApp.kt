package com.klekchyan.harrypottermultiplatform.android

import android.app.Application
import android.content.Context
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.androidCoreContextTranslators
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bindProvider

class HarryPotterApp: Application(), DIAware {
    override val di: DI by DI.lazy {
        bindProvider<Context>(tag = "ApplicationContext") { this@HarryPotterApp }

        import(androidCoreContextTranslators)
        import(androidXModule(this@HarryPotterApp))
    }
}