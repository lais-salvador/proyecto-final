package com.example.app_proyecto_final.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(navController: NavController){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.ListScreen.route
    ){
        addListScreen(navController)
        addDetailScreen(navController)
        addFavoriteScreen()
    }
}