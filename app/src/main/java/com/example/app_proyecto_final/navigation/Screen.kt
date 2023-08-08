package com.example.app_proyecto_final.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String, val arguments: List<NamedNavArgument>) {
    object ListScreen: Screen(
        route = "list",
        arguments = emptyList()
    )
}