package com.example.app_proyecto_final

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app_proyecto_final.navigation.NavigationGraph
import com.example.app_proyecto_final.navigation.Screen
import com.example.app_proyecto_final.presentation.common.bottomBar.BottomBar
import com.example.app_proyecto_final.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var showBottomBar by remember {
                mutableStateOf(false)
            }
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            showBottomBar = showBottomBar(currentRoute)

            AppTheme(useDarkTheme = isSystemInDarkTheme()) {
                Scaffold(
                    bottomBar = {
                        if(showBottomBar) BottomBar(navController = navController)
                    }
                ) {
                    NavigationGraph(navController)
                }
            }
        }
    }
}

fun showBottomBar(currentRoute: String?): Boolean =
    when (currentRoute) {
        Screen.DetailScreen.route+"/{productId}" -> false
        else -> true
    }