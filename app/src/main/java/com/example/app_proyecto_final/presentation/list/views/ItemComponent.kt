package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemComponent(product: ProductModel ,onDetailClick: () -> Unit) {
    ElevatedCard(
        onClick = onDetailClick,
        modifier = Modifier
            .padding(horizontal = Dimens.CardSideMargin)
            .padding(bottom = Dimens.CardBottomMargin),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimens.CardElevation)
        ) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model =
                ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .size(Size.ORIGINAL)
                    .build(),
                contentDescription = product.title,
                modifier = Modifier
                    .height(Dimens.listItemImageHeight)
                    .fillMaxWidth(),
                contentScale =  ContentScale.Crop,
            )
        }

        Column(
            modifier = Modifier.padding(Dimens.PaddingSmall)
        ) {
            Text(
                text = product.title,
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.price.toString(),
                maxLines = 1,
            )
        }



    }
}