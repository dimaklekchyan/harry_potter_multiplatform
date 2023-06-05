package com.klekchyan.harrypottermultiplatform.data.repository

import com.klekchyan.harrypottermultiplatform.core.Either
import com.klekchyan.harrypottermultiplatform.data.db.Database
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.data.network.HarryPotterApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HarryPotterRepositoryImpl(
    private val database: Database,
    private val api: HarryPotterApi
): HarryPotterRepository {

    override suspend fun getCharacters(forceReload: Boolean): Flow<Either<List<Character>>> = flow {
        emit(Either.loading())
        val cache = database.getAllCharacters()
        emit(Either.success(cache))
        if (cache.isEmpty() || forceReload) {
            val apiResult = api.getAllCharacters()
            apiResult.onError {
                emit(Either.error(it))
            }
            apiResult.onSuccess { characters ->
                database.clearDatabase()
                database.saveCharacters(characters ?: emptyList())
                val newCache = database.getAllCharacters()
                emit(Either.success(newCache))
            }
        }
    }

    override suspend fun getSpecificCharacter(id: String): Character? {
        return database.getAllCharacters().firstOrNull { it.id == id }
    }
}