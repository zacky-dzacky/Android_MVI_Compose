package id.syarief.base.base_component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp


private object SimpleTextSnippet {
    // [START android_compose_text_simple_text]
    @Composable
    fun SimpleText() {
        Text("Hello World")
    }
    // [END android_compose_text_simple_text]
}
@Preview
@Composable
fun TextTitle(){
//    Text("asdf", fontSize = 24.sp)
}
@Preview
@Composable
fun TextSubTitle() {

}
@Preview
@Composable
fun TextNormal() {}

@Preview
@Composable
fun TextToolbar() {}