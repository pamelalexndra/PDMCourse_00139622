package com.example.parcial1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun AddScreen(onSaveTask: (String, String) -> Unit) {

    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var titulo by rememberSaveable { mutableStateOf("") }
            var descripcion by rememberSaveable { mutableStateOf("") }

            AsyncImage(
                model ="https://tse4.mm.bing.net/th/id/OIP.hGb7ge9m7C5ik3nvB2q1rgHaHQ?rs=1&pid=ImgDetMain&o=7&rm=3",
                contentDescription = "imagen de la tarea",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            TextField(
                value = titulo,
                onValueChange = { titulo = it},
                label = { Text("Título")},
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it},
                label = { Text("Descripción")},
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = {
                if (titulo.isNotBlank()) {
                    onSaveTask(titulo, descripcion)
                }
            }) {
                Text("Agregar tarea")
            }
        }
    }
}

/* @Composable
fun AddScreen(onSaveTask: (String, String) -> Unit) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var descripcion by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model ="https://tse4.mm.bing.net/th/id/OIP.hGb7ge9m7C5ik3nvB2q1rgHaHQ?rs=1&pid=ImgDetMain&o=7&rm=3",
            contentDescription = "imagen de la tarea",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        TextField(
            value = titulo,
            onValueChange = { titulo = it},
            label = { Text("Título")},
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it},
            label = { Text("Descripción")},
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            if (titulo.isNotBlank()) {
                onSaveTask(titulo, descripcion)
            }
        }) {
            Text("Agregar tarea")
        }
    }
} */