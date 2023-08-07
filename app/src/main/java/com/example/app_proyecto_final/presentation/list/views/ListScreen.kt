package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app_proyecto_final.ui.theme.Dimens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen() {
    Scaffold() { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(
                horizontal = Dimens.CardSideMargin,
                vertical = Dimens.headerMargin
            )
        ) {
            items(
                items = listOf(1,2,3,4,5,6,7,8,9,0,1,2,3,4),
                key = { it }
            ) { it ->
                ItemComponent {}
            }
        }
    }

}

