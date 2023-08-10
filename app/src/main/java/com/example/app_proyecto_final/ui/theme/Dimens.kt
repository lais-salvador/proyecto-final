package com.example.app_proyecto_final.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.example.app_proyecto_final.R

object Dimens {
    val PaddingSmall: Dp
        @Composable get() = dimensionResource(R.dimen.padding_small)

    val PaddingNormal: Dp
        @Composable get() = dimensionResource(R.dimen.padding_normal)

    val CardElevation: Dp
        @Composable get() = dimensionResource(R.dimen.card_elevation)

    val CardSideMargin: Dp
        @Composable get() = dimensionResource(R.dimen.card_side_margin)

    val CardBottomMargin: Dp
        @Composable get() = dimensionResource(R.dimen.card_bottom_margin)

    val CardDetailHeight: Dp
        @Composable get() = dimensionResource(R.dimen.card_detail_height)

    val listItemImageHeight: Dp
        @Composable get() = dimensionResource(R.dimen.list_item_image_height)

    val headerMargin: Dp
        @Composable get() = dimensionResource(R.dimen.header_margin)

    val PaddingLarge: Dp
        @Composable get() = dimensionResource(R.dimen.padding_large)
}