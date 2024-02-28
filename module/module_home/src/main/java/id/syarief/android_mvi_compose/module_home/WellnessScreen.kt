package id.syarief.android_mvi_compose.module_home

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import id.syarief.base.base_component.BaseTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTaskList(
            modifier = Modifier,
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckTask = { task, checked -> wellnessViewModel.changeTaskCheced(task, checked) }
        )
    }
}

@Composable
fun WellnessScreen2(
    state: UsersContract.State,
    effectFlow: Flow<UsersContract.Effect>?,
    onEventSent: (event: UsersContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: UsersContract.Effect.Navigation) -> Unit
) {
    Column(modifier = Modifier) {
        StatefulCounter()
        when {
            state.isLoading -> Text(text = "Loading")
            state.isError -> Text(text = "Error")//NetworkError { onEventSent(UsersContract.Event.Retry) }
            else -> WellnessTaskList(
                modifier = Modifier,
                list = state.users,
                onCloseTask = { task -> Log.d("asdfasdf", "${task.userId}") },//task -> wellnessViewModel.remove(task) },
                onCheckTask = { task, checked -> }//task, checked -> wellnessViewModel.changeTaskCheced(task, checked) }
            ) //{ onEventSent(UsersContract.Event.UserSelection(it)) }
        }
//        WellnessTaskList(
//            modifier = Modifier,
//            list = wellnessViewModel.tasks,
//            onCloseTask = { task -> wellnessViewModel.remove(task) },
//            onCheckTask = { task, checked -> wellnessViewModel.changeTaskCheced(task, checked) }
//        )
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