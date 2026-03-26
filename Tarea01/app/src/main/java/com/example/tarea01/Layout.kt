package com.example.tarea01

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Layout() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth()
                .background(Color(0xFF80FFFF)) // Color cyan claro
        ) {
            Text(
                text = "Ejemplo 1",
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Row(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f) // Mitad del ancho del Row
                    .fillMaxHeight()
                    .background(Color.Red)
            ) {
                Text(
                    text = "Ejemplo 2",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f) // Mitad del ancho del Row
                    .fillMaxHeight()
                    .background(Color.Green)
            ) {
                Text(
                    text = "Ejemplo 3",
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(0.3f)
                .fillMaxWidth()
                .background(Color(0xFFFF00FF))
        ) {
            Text(
                text = "Ejemplo 4",
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}


// Previsualización
@Preview(showBackground = true)
@Composable
fun PreviewMiLayout() {
    Layout()
}