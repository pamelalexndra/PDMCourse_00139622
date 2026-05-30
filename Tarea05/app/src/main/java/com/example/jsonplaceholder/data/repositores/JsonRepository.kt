package com.example.jsonplaceholder.data.repositores

import com.example.jsonplaceholder.model.Json

interface JsonRepository {
    suspend fun getJson(): Result<List<Json>>
    suspend fun postJson(json: Json): Result<Json>
}