package com.example.app_proyecto_final.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun NavigationGraph(navController: NavController, paddingValues: PaddingValues){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.ListScreen.route
    ){
        addListScreen(navController, paddingValues)
        addDetailScreen(paddingValues)
        addFavoriteScreen(navController, paddingValues)
    }
}