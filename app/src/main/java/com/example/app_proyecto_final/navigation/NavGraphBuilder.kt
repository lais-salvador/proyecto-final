package com.example.app_proyecto_final.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.app_proyecto_final.presentation.list.views.ListScreen


fun NavGraphBuilder.addListScreen(){
    composable(Screen.ListScreen.route){
        ListScreen()
    }
}