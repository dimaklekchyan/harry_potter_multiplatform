package com.klekchyan.harrypottermultiplatform.android.vm

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.domain.repository.HarryPotterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val repository: HarryPotterRepository
): ViewModel() {

    var characters by mutableStateOf<List<Character>>(emptyList())
        private set

    init {
        getCharacters(true)
    }

    fun getCharacters(forceReload: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getCharacters(forceReload)
            }.onSuccess {
                characters = it
            }.onFailure {
                Log.d("TAG2", "error: ${it.localizedMessage}")
            }
        }
    }
}