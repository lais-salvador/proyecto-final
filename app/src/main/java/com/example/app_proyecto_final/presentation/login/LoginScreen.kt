package com.example.app_proyecto_final.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto_final.presentation.common.PrimaryButton

@Composable
fun LoginScreen() {
    Box(modifier = Modifier.fillMaxSize()){
        LoginForm({})
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}