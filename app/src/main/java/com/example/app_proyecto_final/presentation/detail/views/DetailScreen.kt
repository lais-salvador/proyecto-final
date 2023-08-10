package com.example.app_proyecto_final.presentation.detail.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.ErrorComponent
import com.example.app_proyecto_final.presentation.common.ProgressIndicatorComponent
import com.example.app_proyecto_final.presentation.detail.DetailState
import com.example.app_proyecto_final.presentation.detail.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    id: String,
    paddingValues: PaddingValues,
    detailViewModel: DetailViewModel= koinViewModel(),
) {
    val state = detailViewModel.productFlow.collectAsStateWithLifecycle()

    detailViewModel.getProductData(id)

    when(state.value) {
        is DetailState.Product -> {
            DetailComponent(
                product = (state.value as DetailState.Product).product,
                onFavorite = { success ->
                    detailViewModel.updateFavoriteState(success, id)
                },
                paddingValues = paddingValues
            )
        }
        is DetailState.Idle -> {}
        is DetailState.Loading -> {
            ProgressIndicatorComponent()
        }
        is DetailState.Error -> {
            ErrorComponent(
                onClick = {detailViewModel.getProductData(id)},
                error = stringResource(id = R.string.error
                )
            )
        }
    }
}