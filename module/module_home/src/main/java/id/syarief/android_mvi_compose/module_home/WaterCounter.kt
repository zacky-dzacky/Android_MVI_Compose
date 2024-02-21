package id.syarief.android_mvi_compose.module_home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.syarief.base.base_component.BaseTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    Column {
        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }
        Button(
            onClick = { count++ },
            modifier = Modifier.padding(top = 10.dp),
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }
}

@Preview
@Composable
fun Preview(){
    BaseTheme {
        Surface(Modifier.fillMaxSize()) {
            WaterCounter()
        }
    }
}