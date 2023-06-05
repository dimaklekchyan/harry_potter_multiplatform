package com.klekchyan.harrypottermultiplatform.data.db

import com.klekchyan.harrypottermultiplatform.platform.PlatformConfiguration
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory actual constructor(platformConfiguration: PlatformConfiguration) {
    actual fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver =
        NativeSqliteDriver(schema, name)
}