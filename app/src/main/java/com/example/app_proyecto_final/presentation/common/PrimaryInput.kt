package com.example.app_proyecto_final.presentation.common

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_proyecto_final.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimaryInput(label: String, icon: Int) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) },
        leadingIcon = {
            Icon(
                painterResource(id = icon),
                contentDescription = "AppLogo",
                modifier = Modifier.alpha(0.5f),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun PrimaryInputPreview(){
    PrimaryInput(label = "Label", R.drawable.eye_icon)
}