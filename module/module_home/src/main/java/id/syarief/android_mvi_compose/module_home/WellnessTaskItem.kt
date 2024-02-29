package id.syarief.android_mvi_compose.module_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.base.base_component.BaseTheme

@Composable
fun WellnessTaskItem(
    taskName: User,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckTask: ( Boolean) -> Unit
) {
    Card(modifier = modifier) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
        ){
            Text(
                text = taskName.userId,
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

}

@Composable
fun WellnessTaskList(
    modifier: Modifier,
    onCloseTask: (User) -> Unit,
    onCheckTask: (User, Boolean) -> Unit,
    list: List<User>
){
    LazyColumn(modifier = modifier) {
        items(items = list, key = {task -> task.userId} ) { task ->
            WellnessTaskItem(
                taskName = task,
                onClose = { onCloseTask(task) },
                checked = false, //task.checked,
                onCheckTask = { onCheckTask(task, it) }
            )
        }
    }
}

@Preview
@Composable
fun WellnessTaskItemPreview() {
    BaseTheme {
        Surface (
            Modifier
                .height(100.dp)
                .padding(16.dp)){
            WellnessTaskItem(
                User(
                    userId = "Nama",
                    avatarUrl = "https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-person-icon.png",
                    htmlUrl = "https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-person-icon.png"
                ),
                {},
                Modifier
                    .height(60.dp),
                true,
                {}
            )
        }
    }
}

//data class WellnessTask(
//    val id: Int,
//    val label: String,
//    val initialCheck: Boolean = false
//){
//    var checked by mutableStateOf(initialCheck)
//}
