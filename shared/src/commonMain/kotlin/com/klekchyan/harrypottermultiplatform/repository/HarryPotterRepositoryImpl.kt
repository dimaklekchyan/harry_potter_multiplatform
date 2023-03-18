package com.klekchyan.harrypottermultiplatform.repository

import com.klekchyan.harrypottermultiplatform.cache.Database
import com.klekchyan.harrypottermultiplatform.entity.Character
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
}