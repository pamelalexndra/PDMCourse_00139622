package com.example.jsonplaceholder.screens.JsonPostScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jsonplaceholder.components.AppScaffold
import com.example.jsonplaceholder.model.Json

@Composable
fun JsonPostScreen(
    navigateBack: () -> Unit,
    viewModel: JsonPostViewModel = viewModel()
) {
    val jsons by viewModel.jsons.collectAsState()
    val error by viewModel.error.collectAsState()

    val context = LocalContext.current

    var userId by rememberSaveable { mutableStateOf("") }
    var title by rememberSaveable { mutableStateOf("") }
    var body by rememberSaveable { mutableStateOf("") }

    fun subir() {
        when {
            (userId.isBlank() || title.isBlank() || body.isBlank()) -> {
                Toast.makeText(
                    context,
                    "Por favor completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }

            error != null -> {
                Toast.makeText(
                    context,
                    error,
                    Toast.LENGTH_SHORT
                ).show()
            }

            else -> {
                val newJson = Json(
                    id = (jsons.size + 1),
                    userId = userId.toIntOrNull() ?: 0,
                    title = title,
                    body = body
                )
                viewModel.addData(newJson)

                userId = ""
                title = ""
                body = ""

                Toast.makeText(
                    context,
                    "Datos enviados correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    AppScaffold(
        title = "Crear nuevo json",

    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            OutlinedTextField(
                value = userId,
                onValueChange = { userId = it },
                label = { Text(text = "Id del usuario") },
                placeholder = { Text(text = "Ingresa el ID de usuario" ) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Títutlo del json") },
                placeholder = { Text(text = "Ingresa el título del json") },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            OutlinedTextField(
                value = body,
                onValueChange = { body = it },
                label = { Text(text = "Ingresa el cuerpo del json") },
                placeholder = { Text(text = "Ingresa el título del json") },
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )

            Button(
                onClick = { subir() },
            ) {
                Text(text = "Publicar")
            }
        }
    }
}