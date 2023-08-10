package com.example.app_proyecto_final.presentation.favorite.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.ErrorComponent
import com.example.app_proyecto_final.presentation.common.ProgressIndicatorComponent
import com.example.app_proyecto_final.presentation.favorite.FavoriteState
import com.example.app_proyecto_final.presentation.favorite.FavoriteViewModel
import com.example.app_proyecto_final.presentation.list.views.ListComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(
    favoriteViewModel: FavoriteViewModel = koinViewModel(),
    paddingValues: PaddingValues,
    onItemClick: (String) -> Unit
    ) {
    val state = favoriteViewModel.productListFlow.collectAsStateWithLifecycle()
    favoriteViewModel.getData()

    when(state.value) {
        is FavoriteState.ProductList -> {
            ListComponent(
                productList = (state.value as FavoriteState.ProductList).productList,
                onItemClick = onItemClick,
                paddingValues = paddingValues
            )
        }
        is FavoriteState.Idle -> {}
        is FavoriteState.Loading -> {
            ProgressIndicatorComponent()
        }
        is FavoriteState.Error -> {
            ErrorComponent(
                onClick = { favoriteViewModel.getData() },
                error = stringResource(id = R.string.error)
            )
        }
    }
}