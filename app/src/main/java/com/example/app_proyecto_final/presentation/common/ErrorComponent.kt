package com.example.app_proyecto_final.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.ui.theme.Dimens

@Composable
fun ErrorComponent(onClick: () -> Unit, error: String) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(Dimens.PaddingNormal)
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = error
        )
        Spacer(modifier = Modifier.height(Dimens.PaddingNormal))
        Button(onClick = onClick) {
            Text(text = stringResource(id = R.string.reload))
        }
    }
}