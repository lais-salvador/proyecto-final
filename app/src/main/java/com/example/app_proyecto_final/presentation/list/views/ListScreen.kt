package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.ErrorComponent
import com.example.app_proyecto_final.presentation.common.ProgressIndicatorComponent
import com.example.app_proyecto_final.presentation.list.ListState
import com.example.app_proyecto_final.presentation.list.ListViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListScreen(
    listViewModel: ListViewModel = koinViewModel(),
    paddingValues: PaddingValues,
    onItemClick: (String) -> Unit,
) {
    val state = listViewModel.productListFlow.collectAsStateWithLifecycle()
    listViewModel.getData()

    when(state.value) {
        is ListState.ProductList -> {
            ListComponent(
                productList = (state.value as ListState.ProductList).productList,
                onItemClick = onItemClick,
                paddingValues = paddingValues
            )
        }
        is ListState.Idle -> {}
        is ListState.Loading -> {
            ProgressIndicatorComponent()
        }
        is ListState.Error -> {
            ErrorComponent(
                onClick = { listViewModel.getData() },
                error = stringResource(id = R.string.error)
            )
        }
    }
}

