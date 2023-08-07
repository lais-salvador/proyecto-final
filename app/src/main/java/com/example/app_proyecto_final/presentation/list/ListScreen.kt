package com.example.app_proyecto_final.presentation.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto_final.presentation.list.DetailList.DetailListScreen
import com.example.app_proyecto_final.ui.theme.Dimens

@Composable
fun ListScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            horizontal = Dimens.CardSideMargin,
            vertical = Dimens.headerMargin
        )
    ) {
        items(
            items = listOf(1, 2, 3, 4, 5, 6),
            key = { it }
        ) { it ->
            DetailListScreen() {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview(){
    ListScreen()
}