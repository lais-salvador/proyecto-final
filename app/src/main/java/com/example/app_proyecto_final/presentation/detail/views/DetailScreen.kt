package com.example.app_proyecto_final.presentation.detail.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.app_proyecto_final.presentation.detail.DetailState
import com.example.app_proyecto_final.presentation.detail.DetailViewModel
import com.example.app_proyecto_final.presentation.list.ListState
import com.example.app_proyecto_final.presentation.list.views.ListComponent
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    id: String,
    detailViewModel: DetailViewModel= koinViewModel()
) {

    val state = detailViewModel.productFlow.collectAsStateWithLifecycle()

    detailViewModel.getProductData(id)

    when(state.value) {
        is DetailState.Product -> {
            DetailComponent(
                product = (state.value as DetailState.Product).product
            )
        }
        is DetailState.Idle -> {}
        is DetailState.Loading -> {}
    }
}