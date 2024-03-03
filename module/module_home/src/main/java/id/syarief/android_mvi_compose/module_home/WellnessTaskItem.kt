package id.syarief.android_mvi_compose.module_home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.base.base_component.BaseTheme
import id.syarief.base.base_component.FullAppBar
import id.syarief.base.base_component.TextToolbar

@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(url)
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxSize()
            .clip(CircleShape),
    )
}

@Composable
fun WellnessTaskItem(
    user: User,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckTask: ( Boolean) -> Unit
) {
    Spacer(modifier = Modifier.height(8.dp))
    Card(modifier = modifier.padding(horizontal = 8.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .clickable(onClick = {
                        onClick(user.userId)
                    })
            ) {
                CoilImage(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape),
                    url = user.avatarUrl,
                    contentDescription = "",
                )
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Text(text = user.userId)
                    Text(text = user.htmlUrl)
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
                user = task,
                onClick = { onCloseTask(task) },
                checked = false, //task.checked,
                onCheckTask = { onCheckTask(task, it) }
            )

        }
    }
}

//@OptIn(ExperimentalGlideComposeApi::class)
@Preview
@Composable
fun WellnessTaskItemPreview() {
    BaseTheme {
        Surface (
            Modifier
                .height(120.dp)
                .padding(16.dp)){
            Row {
                FullAppBar("Github User", true, {})
//                WellnessTaskItem(
//                    User(
//                        userId = "Nama",
//                        avatarUrl = "https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-person-icon.png",
//                        htmlUrl = "https://uxwing.com/wp-content/themes/uxwing/download/peoples-avatars/man-person-icon.png"
//                    ),
//                    { userID ->
//                        Log.d("Asdfasdf", "User ID: $userID")
//                    },
//                    Modifier,
//                    true,
//                    {}
//                )
            }
        }
    }
}
