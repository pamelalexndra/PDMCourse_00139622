package com.example.parcial1.data

import androidx.compose.runtime.mutableStateListOf
import com.example.parcial1.model.Task

val DataTasks = mutableStateListOf(
    Task(
        id = 1,
        titulo = "Estudiar móviles",
        descripcion = "Estudiar navegacion3 para el parcial 1",
        urgencia = 8
    ),
    Task(
        id = 2,
        titulo = "Estudiar redes",
        descripcion = "Investigar porque hay error en la capa 8",
        urgencia = 10
    ),
    Task(
        id = 3,
        titulo = "Estudiar ncapas",
        descripcion = "Dar gracias todos los dias por spring boot, eterno papa de spring",
        urgencia = 7
    )
)

