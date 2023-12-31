package com.example.app_proyecto_final.presentation.list.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemComponent(
    product: ProductModel,
    onItemClick: (() -> Unit)? = null
) {
    val cardContentDescription = stringResource(id = R.string.card_content_description)
    ElevatedCard(
        onClick = { onItemClick?.invoke() },
        modifier = Modifier
            .padding(horizontal = Dimens.CardSideMargin)
            .padding(bottom = Dimens.CardBottomMargin)
            .semantics {
                contentDescription = cardContentDescription
            },
        elevation = CardDefaults.cardElevation(defaultElevation = Dimens.CardElevation),
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
            modifier = Modifier.padding(Dimens.PaddingSmall),
        ) {
            Text(
                text = product.title,
                maxLines = 2,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = product.price,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                )
            }

        }
    }
}