package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemComponent(onDetailClick: () -> Unit) {
    ElevatedCard(
        onClick = onDetailClick,
        modifier = Modifier
            .padding(horizontal = Dimens.CardSideMargin)
            .padding(bottom = Dimens.CardBottomMargin)
            .fillMaxWidth()
            .height(Dimens.CardHeight),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimens.CardElevation)
        ) {
            AsyncImage(
                model = "",
                contentDescription = "",
                Modifier
                    .fillMaxWidth()
                    .height(Dimens.listItemImageHeight),
                contentScale =  ContentScale.Crop,
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight().padding(Dimens.PaddingSmall)
            ) {
                Text(
                    text = "Title",
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Price",
                    maxLines = 1,
                )
            }

    }
}