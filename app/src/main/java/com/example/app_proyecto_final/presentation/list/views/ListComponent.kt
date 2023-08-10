package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.ui.theme.Dimens

@Composable
fun ListComponent(
    productList: List<ProductModel>,
    onItemClick: (String) -> Unit,
    paddingValues: PaddingValues
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            horizontal = Dimens.CardSideMargin,
            vertical = Dimens.headerMargin
        )
    ) {
        items(
            items = productList,
            key = { it.id }
        ) {
            ItemComponent(it){
                onItemClick.invoke(it.id)
            }
        }
    }
}


