package com.klekchyan.harrypottermultiplatform.repository

import com.klekchyan.harrypottermultiplatform.entity.Character

interface HarryPotterRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(forceReload: Boolean): List<Character>
}