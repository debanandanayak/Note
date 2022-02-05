import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.component.Task

@Composable
fun TaskCard(taskData: Task) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .height(170.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Text(
            text = taskData.task,
            modifier = Modifier.padding(10.dp),
            style = MaterialTheme.typography.titleMedium
        )
    }
}
