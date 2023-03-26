package com.klekchyan.harrypottermultiplatform.network

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.kodein.di.*

internal val networkModule = DI.Module("ktorModule") {

    bindConstant(tag = "baseUrl") { "https://hp-api.onrender.com/api/" }

    bindSingleton<HttpClient> {
        HttpClient(HttpEngineFactory().createEngine()) {
            expectSuccess = true
            defaultRequest {
                url(instance<String>(tag = "baseUrl"))
            }
            install(Logging) {
                level = LogLevel.ALL
                logger = Logger.SIMPLE
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 30000
                connectTimeoutMillis = 15000
                socketTimeoutMillis = 30000
            }
            install(ContentNegotiation) {
                json(AppJsonConfiguration.json)
            }
        }
    }

    bindSingleton<HarryPotterApi> {
        HarryPotterApi(instance())
    }
}