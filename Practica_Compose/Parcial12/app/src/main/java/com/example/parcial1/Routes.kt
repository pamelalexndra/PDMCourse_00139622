package com.example.parcial1

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object Home : Routes()


    @Serializable
    data class Add(
        val id: Int
    ) : Routes()
}
