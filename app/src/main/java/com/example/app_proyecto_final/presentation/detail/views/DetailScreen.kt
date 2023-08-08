package com.example.app_proyecto_final.presentation.detail.views

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.presentation.detail.DetailState
import com.example.app_proyecto_final.presentation.detail.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    id: String,
    detailViewModel: DetailViewModel= koinViewModel(),
    onBack: () -> Unit
) {

    val state = detailViewModel.productFlow.collectAsStateWithLifecycle()

    detailViewModel.getProductData(id)

    when(state.value) {
        is DetailState.Product -> {
            DetailComponent(
                product = (state.value as DetailState.Product).product,
                onBack = onBack
            )
        }
        is DetailState.Idle -> {}
        is DetailState.Loading -> {}
    }
}