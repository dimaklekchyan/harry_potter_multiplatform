package com.klekchyan.harrypottermultiplatform.cache

import com.klekchyan.harrypottermultiplatform.entity.Character
import com.klekchyan.harrypottermultiplatform.entity.Wand
import com.klekchyan.harrypottermultiplatform.shared.cache.AppDatabase

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val queries = database.appDatabaseQueries

//    internal fun getAllCharacters(): List<Character> {
//        return queries.getCharacters().ma
//    }

    internal fun clearDatabase() {
        queries.transaction {
            queries.deleteCharacters()
            queries.deleteWands()
        }
    }

    private fun mapCharactersSelecting(
        id: String,
        name: String,
        species: String,
        wood: String,
        core: String,
        length: Double?
    ): Character = Character(
        id = id,
        name = name,
        species = species,
        wand = Wand(wood, core, length)
    )
}