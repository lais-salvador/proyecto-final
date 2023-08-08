package com.example.app_proyecto_final.presentation.detail.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailComponent(
    product: ProductModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.detail_screen_title))
                },
                modifier = Modifier.statusBarsPadding(),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = Dimens.PaddingNormal)
                .padding(vertical = Dimens.headerMargin)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),

        ){
            Text(
                text = product.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2
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
                    contentDescription = product.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale =  ContentScale.Fit,
                )
            }

            Text(
                text = product.price,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            
            Spacer(modifier = Modifier.height(Dimens.PaddingNormal))

            Text(
                text = product.description,
            )
        }
    }
}