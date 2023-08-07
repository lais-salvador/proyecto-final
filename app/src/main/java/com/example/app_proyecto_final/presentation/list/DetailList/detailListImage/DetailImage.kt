package com.example.app_proyecto_final.presentation.list.DetailList.detailListImage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun DetailListImage(
    model: Any?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    if (LocalInspectionMode.current) {
        Box(modifier = modifier.background(Color.Magenta))
        return
    }
    AsyncImage(
        model = model,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
    )
}

@Preview(showBackground = true)
@Composable
fun DetailListImagePreview(){
    DetailListImage("https://i.dummyjson.com/data/products/20/1.jpg","" )
}
