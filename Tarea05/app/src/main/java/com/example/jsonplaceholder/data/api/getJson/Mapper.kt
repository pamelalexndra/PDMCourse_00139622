package com.example.jsonplaceholder.data.api.getJson

import com.example.jsonplaceholder.model.Json

fun JsonDTO.toModel(): Json {
    return Json(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}