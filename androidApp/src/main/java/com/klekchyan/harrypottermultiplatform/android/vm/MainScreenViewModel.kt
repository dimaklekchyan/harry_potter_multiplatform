package com.klekchyan.harrypottermultiplatform.android.vm

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.klekchyan.harrypottermultiplatform.cache.Database
import com.klekchyan.harrypottermultiplatform.cache.DatabaseDriverFactory
import com.klekchyan.harrypottermultiplatform.network.HarryPotterApi
import com.klekchyan.harrypottermultiplatform.repository.HarryPotterRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(
    application: Application
): AndroidViewModel(application) {

    private val databaseDriverFactory = DatabaseDriverFactory(this.getApplication())
    private val harryPotterRepository = HarryPotterRepositoryImpl(
        database = Database(databaseDriverFactory),
        api = HarryPotterApi()
    )

    var characters by mutableStateOf<List<com.klekchyan.harrypottermultiplatform.entity.Character>>(emptyList())
        private set

    init {
        getCharacters(true)
    }

    fun getCharacters(forceReload: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                harryPotterRepository.getCharacters(forceReload)
            }.onSuccess {
                characters = it
            }.onFailure {
                Log.d("TAG2", "error: ${it.localizedMessage}")
            }
        }
    }
}