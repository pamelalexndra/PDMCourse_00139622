package com.example.parcial1

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.parcial1.ui.screens.AddScreen
import com.example.parcial1.ui.screens.HomeScreen
import com.example.parcial1.Routes.Add
import com.example.parcial1.data.DataTasks
import com.example.parcial1.model.Task

@Composable
fun MainNavigate() {
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    onNavigateToAdd = {
                        backstack.add(Add(id = 0))
                    }
                )
            }
            entry<Routes.Add> {
                AddScreen(
                    onSaveTask = { nuevoTitulo, nuevaDesc ->
                        val nuevaTarea = Task(
                            id = DataTasks.size + 1,
                            titulo = nuevoTitulo,
                            descripcion = nuevaDesc,
                            urgencia = 5
                        )
                        DataTasks.add(nuevaTarea)
                        backstack.removeLastOrNull()
                    }
                )
            }
        }
    )
}
