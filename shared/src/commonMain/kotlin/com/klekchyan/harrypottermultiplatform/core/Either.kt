package com.klekchyan.harrypottermultiplatform.core

typealias EitherNone = Either<Either.None>

class Either<out T>(
    val status: Status,
    val data: T? = null,
    val error: Exception? = null,
) {
    val isError: Boolean
        get() = status == Status.ERROR
    val isSuccess: Boolean
        get() = status == Status.SUCCESS
    val isLoading: Boolean
        get() = status == Status.LOADING

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Either<T> =
            Either(Status.SUCCESS, data)

        fun <T> loading(): Either<T> =
            Either(Status.LOADING)

        fun <T> error(error: Exception?): Either<T> =
            Either(status = Status.ERROR, error = error)

        fun none() = Either(
            status = Status.SUCCESS,
            data = None
        )
    }

    suspend fun onError(callBack: suspend (error: Exception?) -> Unit) {
        if (isError) callBack(error)
    }

    suspend fun onLoading(callBack: suspend () -> Unit) {
        if (isLoading) callBack()
    }

    suspend fun onSuccess(callBack: suspend (data: T?) -> Unit) {
        if (isSuccess) callBack(data)
    }

    object None
}
