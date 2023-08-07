package com.example.app_proyecto_final.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_proyecto_final.R
import com.example.app_proyecto_final.presentation.common.PrimaryButton
import com.example.app_proyecto_final.presentation.common.PrimaryInput
import com.example.app_proyecto_final.ui.theme.Dimens

@Composable
fun LoginForm (onLoginSuccess: () -> Unit){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PrimaryInput(label = "Usuario", icon = R.drawable.email_icon)
        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
        PrimaryInput(label = "Contraseña", icon = R.drawable.lock_icon)
        Spacer(modifier = Modifier.height(Dimens.PaddingSmall))
        PrimaryButton(onClick = onLoginSuccess, text = "Login")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview(){
    LoginForm({})
}