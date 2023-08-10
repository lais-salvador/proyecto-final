package com.example.app_proyecto_final.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app_proyecto_final.presentation.detail.views.DetailScreen
import com.example.app_proyecto_final.presentation.favorite.views.FavoriteScreen
import com.example.app_proyecto_final.presentation.list.views.ListScreen


fun NavGraphBuilder.addListScreen(navController: NavController,paddingValues: PaddingValues){
    composable(Screen.ListScreen.route){
        ListScreen(paddingValues = paddingValues){ productId ->
            navController.navigate("${Screen.DetailScreen.route}/$productId")
        }
    }
}

fun NavGraphBuilder.addDetailScreen(paddingValues: PaddingValues) {
    composable(
        route = Screen.DetailScreen.route + "/{productId}",
        arguments = Screen.DetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("productId") ?: ""
        DetailScreen(id = id, paddingValues)
    }
}

fun NavGraphBuilder.addFavoriteScreen(navController: NavController, paddingValues: PaddingValues){
    composable(Screen.FavoriteScreen.route){
        FavoriteScreen(paddingValues = paddingValues){ productId ->
            navController.navigate("${Screen.DetailScreen.route}/$productId")
        }
    }
}