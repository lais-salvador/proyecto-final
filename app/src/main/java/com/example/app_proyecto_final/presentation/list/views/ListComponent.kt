package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListComponent(productList: List<ProductModel>, onDetailClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.list_screen_title))
                },
                modifier = Modifier.statusBarsPadding(),
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding),
            contentPadding = PaddingValues(
                horizontal = Dimens.CardSideMargin,
                vertical = Dimens.headerMargin
            )
        ) {
            items(
                items = productList,
                key = { it.id }
            ) { it ->
                ItemComponent(it, onDetailClick)
            }
        }
    }
}