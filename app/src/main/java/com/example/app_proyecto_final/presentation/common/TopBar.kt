package com.example.app_proyecto_final.presentation.common

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.app_proyecto_final.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(showBackIcon: Boolean, onBack: () -> Unit, text: String) {
    TopAppBar(
        title = {
            Text(text = text)
        },
        modifier = Modifier.statusBarsPadding(),
        navigationIcon = {
            if(showBackIcon)
                IconButton(onClick = onBack) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_content_description)
                    )
                }
        }
    )
}