package com.example.jsonplaceholder.data.api.getJson

import kotlinx.serialization.Serializable

@Serializable
data class JsonDTO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)