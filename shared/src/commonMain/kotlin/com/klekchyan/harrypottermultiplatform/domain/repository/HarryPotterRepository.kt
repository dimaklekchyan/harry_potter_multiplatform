package com.klekchyan.harrypottermultiplatform.domain.repository

import com.klekchyan.harrypottermultiplatform.domain.entity.Character

interface HarryPotterRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(forceReload: Boolean): List<Character>

    @Throws(Exception::class)
    suspend fun getSpecificCharacter(id: String): Character?

    @Throws(Exception::class)
    suspend fun getStudents(forceReload: Boolean): List<Character>

    @Throws(Exception::class)
    suspend fun getStaff(forceReload: Boolean): List<Character>
}