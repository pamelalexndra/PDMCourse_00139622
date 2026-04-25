package com.example.parcial1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SuggestionChip
import com.example.parcial1.data.DataTasks
import com.example.parcial1.ui.theme.components.TaskCard
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial1.ui.theme.Parcial1Theme

@Composable
fun HomeScreen(onNavigateToAdd: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToAdd) {
                Text("+")
            }
        }
    ) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

        LazyRow(modifier = Modifier.padding(8.dp)) {
                items(listOf("Urgente", "Normal", "Baja")) { cat ->
                    SuggestionChip(
                        onClick = {},
                        label = { Text(cat) },
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

            LazyColumn {
                items(DataTasks) { task ->
                    TaskCard(task = task)
                }
            }
        }
    }
}

/*
SIN SCAFFOLD

@Composable
fun HomeScreen(onNavigateToAdd: () -> Unit) {

    Column {
        LazyRow()
        LazyColumn()
    }

    FloatingActionButton(
        onClick = onNavigateToAdd,
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
        ) {
            Text("+"
           }
}

*/

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    Parcial1Theme {
        HomeScreen({})
    }
}
