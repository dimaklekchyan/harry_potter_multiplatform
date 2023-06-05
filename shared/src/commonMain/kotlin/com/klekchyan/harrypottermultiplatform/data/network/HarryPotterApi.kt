package com.klekchyan.harrypottermultiplatform.data.network

import com.klekchyan.harrypottermultiplatform.core.Either
import com.klekchyan.harrypottermultiplatform.data.network.entity.CharacterApiEntity
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.*

class HarryPotterApi(private val client: HttpClient): BaseApi() {
    suspend fun getAllCharacters(): Either<List<CharacterApiEntity>> {
        return doRequest<List<CharacterApiEntity>> { client.get("characters") }
    }
}