package com.klekchyan.harrypottermultiplatform.database

import com.klekchyan.harrypottermultiplatform.platform.PlatformConfiguration
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory actual constructor(
    private val platformConfiguration: PlatformConfiguration
) {
    actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver {
        return AndroidSqliteDriver(schema, platformConfiguration.androidContext, name)
    }
}