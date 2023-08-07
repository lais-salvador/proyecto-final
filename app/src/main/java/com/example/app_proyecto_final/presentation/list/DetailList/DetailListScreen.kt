package com.example.app_proyecto_final.presentation.list.DetailList

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.list.DetailList.detailListImage.DetailListImage
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailListScreen(onClick: () -> Unit) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = Dimens.CardSideMargin)
            .padding(bottom = Dimens.CardBottomMargin)
            .width(150.dp)
            .height(150.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimens.CardElevation)
        ) {
            DetailListImage(
                model = "",
                contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(Dimens.listItemImageHeight),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Producto 1",
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = Dimens.PaddingNormal)
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailListScreenPreview(){
    DetailListScreen({})
}