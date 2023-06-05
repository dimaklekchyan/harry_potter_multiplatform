package com.klekchyan.harrypottermultiplatform.data.network

import com.klekchyan.harrypottermultiplatform.core.Either
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess

open class BaseApi {
    internal suspend inline fun <reified T> doRequest(
        request: () -> HttpResponse,
    ): Either<T> {
        return try {
            val result = request()
            when {
                result.status.isSuccess() -> {
                    val content = result.body<T>()
                    Either.success(content)
                }
                result.status.isClientError() -> {
                    Either.error(Exception("Client error"))
                }
                result.status.isServerError() -> {
                    Either.error(Exception("Server error"))
                }
                else -> Either.error(Exception("Unknown error"))
            }
        } catch (ex: Exception) {
            Either.error(ex)
        }
    }
}

private fun HttpStatusCode.isClientError(): Boolean = value in (400 until 500)
private fun HttpStatusCode.isServerError(): Boolean = value in (500 until 600)