package com.klekchyan.harrypottermultiplatform.data.db

import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.domain.entity.Wand
import com.klekchyan.harrypottermultiplatform.data.network.entity.CharacterApiEntity
import com.klekchyan.harrypottermultiplatform.data.network.entity.WandApiEntity
import com.klekchyan.harrypottermultiplatform.shared.cache.AppDatabase
import com.klekchyan.harrypottermultiplatform.utils.allNotNull

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver(AppDatabase.Schema, "app_database.db"))
    private val queries = database.appDatabaseQueries

    internal fun getAllCharacters(): List<Character> {
        return queries.getCharacters(::mapCharactersSelecting).executeAsList()
    }

    internal fun saveCharacters(characters: List<CharacterApiEntity>) {
        queries.transaction {
            characters.forEach { character ->
                insertCharacter(character)
                character.wand?.let { wand ->
                    insertWand(wand, character.id)
                }
            }
        }
    }

    private fun insertCharacter(character: CharacterApiEntity) {
        queries.insertCharacter(
            id = character.id,
            name = character.name,
            species = character.species,
            hogwartsStudent = character.hogwartsStudent,
            hogwartsStaff = character.hogwartsStaff
        )
    }

    private fun insertWand(wand: WandApiEntity, characterId: String) {
        queries.insertWand(
            wood = wand.wood,
            core = wand.core,
            length = wand.length,
            character_id = characterId
        )
    }

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
        hogwartsStudent: Boolean,
        hogwartsStaff: Boolean,
        id_: Long?,
        wood: String?,
        core: String?,
        length: Double?,
        character_id: String?,
    ): Character = Character(
        id = id,
        name = name,
        species = species,
        hogwartsStudent = hogwartsStudent,
        hogwartsStaff = hogwartsStaff,
        wand = allNotNull(wood, core) { woodNotNull, coreNotNull -> Wand(woodNotNull, coreNotNull, length) }
    )
}