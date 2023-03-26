package com.klekchyan.harrypottermultiplatform.network

import com.klekchyan.harrypottermultiplatform.network.entity.CharacterApiEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

class HarryPotterApi(private val client: HttpClient) {
    suspend fun getAllCharacters(): List<CharacterApiEntity> {
        return client.get("characters").body<List<CharacterApiEntity>>()
    }
}