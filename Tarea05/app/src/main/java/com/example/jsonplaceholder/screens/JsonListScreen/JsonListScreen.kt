package com.example.jsonplaceholder.screens.JsonListScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import com.example.jsonplaceholder.components.AppScaffold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JsonListScreen(
    navigateToCreate: () -> Unit,
    viewModel: JsonListViewModel = viewModel()
) {
    val json by viewModel.json.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()
    val refresh by viewModel.refresh.collectAsState()

    AppScaffold(
        title = "Datos de json",
        actions = {
            IconButton(onClick = { navigateToCreate() }) {
                Icon(
                    imageVector = Icons.Default.AddCircleOutline,
                    contentDescription = "Crear nuevo"
                )
            }
        }
    ) { padding ->

        when {
            loading -> {
                AppScaffold(title = "JsonData") {
                    CircularProgressIndicator()
                }
            }

            error != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        12.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Text(text= "$error", textAlign = TextAlign.Center)
                    Button(
                        onClick = { viewModel.loadJson() }
                    ) {
                        Text(text = "Reintentar")
                    }
                }
            }

            else -> {
                PullToRefreshBox(
                    isRefreshing = refresh,
                    onRefresh = { viewModel.refreshJson() },
                    modifier = Modifier.fillMaxSize().padding(padding)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(json) { json ->
                            JsonItem(json = json)
                        }
                    }
                }
            }
        }
    }
}