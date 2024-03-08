package id.syarief.android_mvi_compose.module_home.ui.feature.users.composable

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.syarief.android_mvi_compose.module_home.ui.feature.users.UsersContract
import id.syarief.base.base_component.BaseTheme
import id.syarief.base.base_component.FullAppBar
import kotlinx.coroutines.flow.Flow

@Composable
fun UsersScreen(
    state: UsersContract.State,
    effectFlow: Flow<UsersContract.Effect>?,
    onEventSent: (event: UsersContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: UsersContract.Effect.Navigation) -> Unit
) {
    Column {
        FullAppBar(title = "Github User", showBack = true) {
//            onNavigationRequested(UsersContract.Effect.Back)
//                        Navigator.navigate(this@HomeActivity, ModuleManifest.ACTIVITY_LOGIN)
//                        finish()
        }
        Column(modifier = Modifier) {
            when {
                state.isLoading -> Text(text = "Loading")
                state.isError -> Text(text = "Error")//NetworkError { onEventSent(UsersContract.Event.Retry) }
                else -> WellnessTaskList(
                    modifier = Modifier,
                    list = state.users,
                    onClickCard = { task ->
//                        Log.d(
//                            "asdfasdf",
//                            "${task.userId}"
//                        )
                                  onNavigationRequested(UsersContract.Effect.Navigation.ToDetail(task.userId))
                    },//task -> wellnessViewModel.remove(task) },
                    onCheckTask = { task, checked -> }//task, checked -> wellnessViewModel.changeTaskCheced(task, checked) }
                ) //{ onEventSent(UsersContract.Event.UserSelection(it)) }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WaterCounterPreview(){
    BaseTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
//            WellnessScreen2()
        }
    }
}