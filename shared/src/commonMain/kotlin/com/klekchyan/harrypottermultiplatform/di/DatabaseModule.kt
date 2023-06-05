package com.klekchyan.harrypottermultiplatform.di

import com.klekchyan.harrypottermultiplatform.data.db.Database
import com.klekchyan.harrypottermultiplatform.data.db.DatabaseDriverFactory
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