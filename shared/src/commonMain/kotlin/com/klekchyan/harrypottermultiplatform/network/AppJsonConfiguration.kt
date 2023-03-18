package com.klekchyan.harrypottermultiplatform.network

import kotlinx.serialization.json.Json

object AppJsonConfiguration {
    val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
        isLenient = true
    }
}