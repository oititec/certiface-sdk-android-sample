package br.com.oiti.certiface.sample.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Button(text: String, action: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = { action() },
        modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = text)
    }
}