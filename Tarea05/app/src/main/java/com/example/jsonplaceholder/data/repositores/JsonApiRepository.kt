package com.example.jsonplaceholder.data.repositores

import com.example.jsonplaceholder.data.api.KtorClient
import com.example.jsonplaceholder.data.api.getJson.CreatePostRequestDTO
import com.example.jsonplaceholder.data.api.getJson.JsonDTO
import com.example.jsonplaceholder.data.api.getJson.toModel
import com.example.jsonplaceholder.model.Json
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class JsonApiRepository : JsonRepository {
    override suspend fun getJson(): Result<List<Json>> {
        try {
            val response: List<JsonDTO> = KtorClient.client.get("posts") {

            }.body()
            return Result.success(response.map { jsonDTO -> jsonDTO.toModel() })
        } catch(e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun postJson(json: Json): Result<Json> {
        try {
            val request = CreatePostRequestDTO(
                userId = json.userId,
                title = json.title,
                body = json.body
            )
            val response: JsonDTO = KtorClient.client.post("posts") {
                contentType(ContentType.Application.Json)
                setBody(request)
            }.body()

            return Result.success(response.toModel())
        } catch(e: Exception) {
            return Result.failure(e)
        }
    }
}