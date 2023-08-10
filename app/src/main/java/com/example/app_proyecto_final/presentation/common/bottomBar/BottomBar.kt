package com.example.app_proyecto_final.presentation.common.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.navigation.Screen

@Composable
fun BottomBar(navController: NavController) {
    val bottomNavItems = listOf(
        BottomNavItem(
            name = stringResource(id = R.string.list_screen_title),
            route = Screen.ListScreen.route,
            icon = Icons.Default.Home
        ),
        BottomNavItem(
            name = stringResource(id = R.string.favorite_screen_title),
            route = Screen.FavoriteScreen.route,
            icon = Icons.Default.Favorite,
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        bottomNavItems.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigate(item.route) },
                label = {
                    Text(
                        text = item.name,
                    )
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(id = R.string.icon_menu_content_description, item.name),
                    )
                }
            )
        }
    }
}