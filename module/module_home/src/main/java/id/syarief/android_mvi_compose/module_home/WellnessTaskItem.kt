package id.syarief.android_mvi_compose.module_home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.syarief.base.base_component.BaseTheme

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckTask: ( Boolean) -> Unit
) {
    Row (modifier = modifier, verticalAlignment = Alignment.CenterVertically){
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckTask(it)}
        )
        IconButton(onClick = onClose ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskList(
    modifier: Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckTask: (WellnessTask, Boolean) -> Unit,
    list: List<WellnessTask>
){
    LazyColumn(modifier = modifier) {
        items(items = list, key = {task -> task.id} ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                checked = task.checked,
                onCheckTask = { onCheckTask(task, it) }
            )
        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    BaseTheme {
        Surface (Modifier.fillMaxSize()){
//            WellnessTaskList(Modifier)
        }
    }
}

data class WellnessTask(
    val id: Int,
    val label: String,
    val initialCheck: Boolean = false
){
    var checked by mutableStateOf(initialCheck)
}
