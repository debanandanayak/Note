import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FAB(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Add Task") },
        icon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Plus Icon"
            )
        },
        onClick = onClick,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    )
}