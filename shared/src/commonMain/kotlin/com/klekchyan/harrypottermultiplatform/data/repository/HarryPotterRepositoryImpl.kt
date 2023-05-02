package com.klekchyan.harrypottermultiplatform.data.repository

import com.klekchyan.harrypottermultiplatform.data.Database
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import com.klekchyan.harrypottermultiplatform.network.HarryPotterApi

class HarryPotterRepositoryImpl(
    private val database: Database,
    private val api: HarryPotterApi
): HarryPotterRepository {

    @Throws(Exception::class)
    override suspend fun getCharacters(forceReload: Boolean): List<Character> {
        val cache = database.getAllCharacters()
        return if (cache.isNotEmpty() && forceReload) {
            cache
        } else {
            val apiResult = api.getAllCharacters()
            database.clearDatabase()
            database.saveCharacters(apiResult)
            database.getAllCharacters()
        }
    }

    @Throws(Exception::class)
    override suspend fun getSpecificCharacter(id: String): Character? {
        return database.getAllCharacters().firstOrNull { it.id == id }
    }

    @Throws(Exception::class)
    override suspend fun getStudents(forceReload: Boolean): List<Character> {
        return getCharacters(forceReload).filter { it.hogwartsStudent }
    }

    @Throws(Exception::class)
    override suspend fun getStaff(forceReload: Boolean): List<Character> {
        return getCharacters(forceReload).filter { it.hogwartsStaff }
    }
}