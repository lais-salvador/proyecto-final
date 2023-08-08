package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.presentation.list.ListState
import com.example.app_proyecto_final.presentation.list.ListViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListScreen(
    listViewModel: ListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = listViewModel.productListFlow.collectAsStateWithLifecycle()

    when(state.value) {
        is ListState.ProductList -> {
            ListComponent(
                productList = (state.value as ListState.ProductList).productList,
                onItemClick = onItemClick
            )
        }
        is ListState.Idle -> {}
        is ListState.Loading -> {}
    }
}

