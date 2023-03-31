package com.klekchyan.harrypottermultiplatform.domain.repository

import com.klekchyan.harrypottermultiplatform.domain.entity.Character

interface HarryPotterRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(forceReload: Boolean): List<Character>
}