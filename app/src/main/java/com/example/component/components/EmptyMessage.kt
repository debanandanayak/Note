package com.example.component.components
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun EmptyMessage() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .height(50.dp),
        backgroundColor = MaterialTheme.colorScheme.tertiaryContainer,
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "No task is present",
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
