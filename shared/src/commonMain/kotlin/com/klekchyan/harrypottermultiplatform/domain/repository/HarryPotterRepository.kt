package com.klekchyan.harrypottermultiplatform.domain.repository

import com.klekchyan.harrypottermultiplatform.core.Either
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import kotlinx.coroutines.flow.Flow

interface HarryPotterRepository {
    suspend fun getCharacters(forceReload: Boolean): Flow<Either<List<Character>>>

    suspend fun getSpecificCharacter(id: String): Character?
}