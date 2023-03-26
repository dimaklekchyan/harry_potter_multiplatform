package com.klekchyan.harrypottermultiplatform.network

import io.ktor.client.engine.*

internal expect class HttpEngineFactory constructor(){
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}