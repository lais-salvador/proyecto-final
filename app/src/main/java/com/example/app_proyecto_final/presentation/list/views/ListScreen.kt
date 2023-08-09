package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.ErrorComponent
import com.example.app_proyecto_final.presentation.common.ProgressIndicatorComponent
import com.example.app_proyecto_final.presentation.list.ListState
import com.example.app_proyecto_final.presentation.list.ListViewModel
import com.example.app_proyecto_final.ui.theme.Dimens
import org.koin.androidx.compose.koinViewModel


@Composable
fun ListScreen(
    listViewModel: ListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = listViewModel.productListFlow.collectAsStateWithLifecycle()
    listViewModel.getData()

    when(state.value) {
        is ListState.ProductList -> {
            ListComponent(
                productList = (state.value as ListState.ProductList).productList,
                onItemClick = onItemClick
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

