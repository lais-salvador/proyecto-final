package com.example.app_proyecto_final.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String, val arguments: List<NamedNavArgument>) {
    object ListScreen: Screen(
        route = "list",
        arguments = emptyList()
    )

    object DetailScreen: Screen(
        route = "detail",
        arguments = listOf(
            navArgument("productId") {
                type = NavType.StringType
                nullable = false
            }
        )
    )

    object FavoriteScreen: Screen(
        route = "favorite",
        arguments = emptyList()
    )
}