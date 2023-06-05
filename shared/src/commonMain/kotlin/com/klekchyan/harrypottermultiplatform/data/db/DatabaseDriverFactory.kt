package com.klekchyan.harrypottermultiplatform.data.db

import com.klekchyan.harrypottermultiplatform.platform.PlatformConfiguration
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(schema: SqlDriver.Schema, name: String): SqlDriver
}