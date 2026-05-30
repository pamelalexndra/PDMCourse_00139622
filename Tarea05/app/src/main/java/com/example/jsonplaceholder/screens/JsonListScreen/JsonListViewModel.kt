package com.example.jsonplaceholder.screens.JsonListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jsonplaceholder.data.repositores.JsonApiRepository
import com.example.jsonplaceholder.data.repositores.JsonRepository
import com.example.jsonplaceholder.model.Json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JsonListViewModel : ViewModel() {

    private val jsonRepository: JsonRepository = JsonApiRepository()

    private val _json = MutableStateFlow<List<Json>>(emptyList())
    val json = _json.asStateFlow()

    private val _loading = MutableStateFlow<Boolean>(false)
    val loading = _loading.asStateFlow()

    private val _refresh = MutableStateFlow<Boolean>(false)
    val refresh = _refresh.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    init {
        loadJson()
    }

    fun loadJson() {
        viewModelScope.launch {
            _error.value = null
            _loading.value = true

            jsonRepository.getJson()
                .onSuccess { json ->
                    _json.value = json
                }
                .onFailure { error ->
                    _error.value = "Ocurrió un error. Intenta recargar la página nuevamente"
                }
            _loading.value = false
        }
    }

    fun refreshJson() {
        viewModelScope.launch {
            _error.value = null
            _refresh.value = true

            jsonRepository.getJson()
                .onSuccess { json ->
                    _json.value = json
                }
                .onFailure { error ->
                    _error.value = "Ocurrió un error. Intenta recargar la página nuevamente"
                }
            _refresh.value = false
        }
    }
}