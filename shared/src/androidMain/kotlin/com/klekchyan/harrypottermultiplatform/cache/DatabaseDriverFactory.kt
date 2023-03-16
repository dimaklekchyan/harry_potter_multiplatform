package com.klekchyan.harrypottermultiplatform.cache

import android.content.Context
import com.klekchyan.harrypottermultiplatform.shared.cache.AppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(AppDatabase.Schema, context, "app_database.db")
}