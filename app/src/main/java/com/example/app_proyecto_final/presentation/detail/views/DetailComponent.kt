package com.example.app_proyecto_final.presentation.detail.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.presentation.detail.customViews.CategoryTagComponent
import com.example.app_proyecto_final.ui.theme.Dimens
import kotlinx.coroutines.job

val requester = FocusRequester()
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailComponent(
    product: ProductModel,
    onFavorite: (isFavorite: Boolean) -> Unit,
    paddingValues: PaddingValues
) {
    Box() {
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = Dimens.PaddingNormal)
                .padding(vertical = Dimens.headerMargin)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState()),
        ){
            Text(
                text = product.title,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge
            )

            ElevatedCard(
                modifier = Modifier
                    .padding(vertical = Dimens.PaddingNormal)
                    .height(Dimens.CardDetailHeight),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = Dimens.CardElevation
                )

            ) {
                AsyncImage(
                    model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(product.image)
                        .size(Size.ORIGINAL)
                        .build(),
                    contentDescription = stringResource(id =  R.string.detail_image_content_description, product.title),
                    modifier = Modifier
                        .fillMaxSize()
                        .focusRequester(focusRequester = requester),
                    contentScale =  ContentScale.Fit,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val contentDescriptionCategoryText = stringResource(id =  R.string.category_tag_content_description, product.title)
                AndroidView(
                    modifier = Modifier
                        .semantics {
                            contentDescription = contentDescriptionCategoryText
                        },
                    factory = { context ->
                        CategoryTagComponent(context).apply {
                            this.setCategoryText(product.category)
                        }
                    }
                )

                Text(
                    text = product.price,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        var added by remember {
            mutableStateOf(product.favorite)
        }
        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(Dimens.PaddingNormal),
            onClick = {
                added = !added
                onFavorite(added)
            },
        ) {
            Icon(
                imageVector = if(added) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = stringResource(id = R.string.favorite_content_description, product.title)
            )
        }
    }

    LaunchedEffect(Unit) {
        this.coroutineContext.job.invokeOnCompletion {
            requester.requestFocus()
        }
    }
}