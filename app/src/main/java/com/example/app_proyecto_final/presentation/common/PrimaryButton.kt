package com.example.app_proyecto_final.presentation.common
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(onClick: () -> Unit, text: String) {
    Button(
        onClick,
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton({}, "Text")
}