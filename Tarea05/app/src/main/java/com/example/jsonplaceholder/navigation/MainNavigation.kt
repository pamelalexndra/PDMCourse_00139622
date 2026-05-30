package com.example.jsonplaceholder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.jsonplaceholder.screens.JsonListScreen.JsonListScreen
import com.example.jsonplaceholder.screens.JsonPostScreen.JsonPostScreen

@Composable
fun MainNavigation() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                JsonListScreen(
                    navigateToCreate = { backStack.add(Routes.Create) }
                )
            }
            entry<Routes.Create> {
                JsonPostScreen(
                    navigateBack = { backStack.removeLastOrNull() }
                )
            }
        }
    )

}