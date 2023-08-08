package com.example.app_proyecto_final.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app_proyecto_final.presentation.detail.views.DetailScreen
import com.example.app_proyecto_final.presentation.list.views.ListScreen


fun NavGraphBuilder.addListScreen(navController: NavController){
    composable(Screen.ListScreen.route){
        ListScreen{ productId ->
            navController.navigate("${Screen.DetailScreen.route}/$productId")
        }
    }
}

fun NavGraphBuilder.addDetailScreen(navController: NavController) {
    composable(
        route = Screen.DetailScreen.route + "/{productId}",
        arguments = Screen.DetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("productId") ?: ""
        DetailScreen(id = id) {
            navController.popBackStack()
        }
    }
}