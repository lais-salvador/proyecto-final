package com.example.app_proyecto_final.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.PrimaryButton
import com.example.app_proyecto_final.presentation.common.PrimaryInput

@Composable
fun LoginForm (onClick: () -> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryInput(label = "Usuario", icon = R.drawable.email_icon)
        PrimaryInput(label = "Contraseña", icon = R.drawable.lock_icon)
        PrimaryButton(onClick, text = "Login")

    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview(){
    LoginForm({})
}