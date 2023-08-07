package com.example.app_proyecto_final.presentation.login.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto_final.R

@Composable
fun LoginHeader() {
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.login_image),
        contentScale = ContentScale.FillWidth,
        contentDescription = "App Name"
    )
}

@Preview(showBackground = true)
@Composable
fun LoginHeaderPreview(){
    LoginHeader()
}