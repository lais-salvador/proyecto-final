package com.example.app_proyecto_final

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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app_proyecto_final.navigation.NavigationGraph
import com.example.app_proyecto_final.navigation.Screen
import com.example.app_proyecto_final.presentation.common.TopBar
import com.example.app_proyecto_final.presentation.common.bottomBar.BottomBar
import com.example.app_proyecto_final.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            var showBottomBar by remember {
                mutableStateOf(false)
            }

            showBottomBar = showBottomBar(currentRoute)

            AppTheme(useDarkTheme = isSystemInDarkTheme()) {
                Scaffold(
                    topBar = { SelectTopBar(currentRoute, navController) },
                    bottomBar = {
                        if(showBottomBar) BottomBar(navController = navController)
                    }
                ) {
                    NavigationGraph(navController, it)
                }
            }
        }
    }
}

fun showBottomBar(currentRoute: String?): Boolean =
    when (currentRoute) {
        Screen.DetailScreen.route+"/{productId}" -> false
        Screen.ListScreen.route -> true
        Screen.FavoriteScreen.route -> true
        else -> false
    }
@Composable
fun SelectTopBar(currentRoute: String?, navController: NavController) {
    val listScreenTitle = stringResource(id = R.string.list_screen_title)
    val detailScreenTitle = stringResource(id = R.string.detail_screen_title)
    val favoriteScreenTitle = stringResource(id = R.string.favorite_screen_title)

    return when(currentRoute){
        Screen.ListScreen.route -> {
            TopBar(showBackIcon = false,
                onBack = {},
                text = listScreenTitle
            )
        }
        Screen.DetailScreen.route+"/{productId}" -> {
            TopBar(showBackIcon = true,
                onBack = {navController.popBackStack()},
                text = detailScreenTitle
            )
        }
        Screen.FavoriteScreen.route -> {
            TopBar(showBackIcon = false,
                onBack = {},
                text = favoriteScreenTitle
            )
        }
        else -> {}
    }
}