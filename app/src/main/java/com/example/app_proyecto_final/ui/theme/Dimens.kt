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

    val PaddingLarge: Dp
        @Composable get() = dimensionResource(R.dimen.padding_large)
}