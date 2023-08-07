package com.example.app_proyecto_final.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app_proyecto_final.presentation.login.views.LoginScreen

fun NavGraphBuilder.addLoginScreen(navController: NavController){
    composable(Screen.LoginScreen.route){
        LoginScreen(
            onLoginSuccess = { navController.navigate(Screen.ListScreen.route) },
        )
    }
}

fun NavGraphBuilder.addListScreen(navController: NavController){
    composable(Screen.ListScreen.route){}
}