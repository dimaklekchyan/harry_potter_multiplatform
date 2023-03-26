package com.klekchyan.harrypottermultiplatform.database

import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val databaseModule = DI.Module("databaseModule ") {
    bindSingleton<DatabaseDriverFactory>() {
        DatabaseDriverFactory(instance())
    }
    bindSingleton<Database> {
        Database(instance())
    }
}