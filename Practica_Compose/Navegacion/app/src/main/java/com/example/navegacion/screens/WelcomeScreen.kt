package com.example.navegacion.screens

import androidx.compose.material3.Button
import androidx.compose.material3.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TitleApp() {
    Text(text = R.string.app_name)
    Button(onClick = () -> Unit) {
        Text("Ir a catalogo")
    }
}