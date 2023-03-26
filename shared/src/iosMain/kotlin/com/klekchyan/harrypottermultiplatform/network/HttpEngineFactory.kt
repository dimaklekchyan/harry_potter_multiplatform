package com.klekchyan.harrypottermultiplatform.network

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

internal actual class HttpEngineFactory actual constructor(){
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig> = Darwin
}