package com.example.jsonplaceholder.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    title: String? = null,
    actions: @Composable RowScope.() -> Unit = {},
    onFabClick: (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
    ) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (title != null) {
                TopAppBar(
                    title = { Text(title) },
                    actions = actions
                )
            }
        },
        floatingActionButton = {
            if (onFabClick != null) {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar")
                }
            }
        }
    ) {
        innerPadding ->
        content(innerPadding)
    }
}