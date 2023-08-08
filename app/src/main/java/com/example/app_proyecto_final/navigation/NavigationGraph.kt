package com.example.app_proyecto_final.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ListScreen.route
    ){
        addListScreen(navController)
        addDetailScreen()
    }
}