package com.samrez.module_login

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samrez.module_login.ui.theme.AndroidMVIComposeTheme
import id.syarief.android_mvi_compose.module_login.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidMVIComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun GreetingPreview() {
    AndroidMVIComposeTheme {
        Row (modifier = Modifier.padding(all = 16.dp)) {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                for(i in 0..3){
                    Greeting(name = "Android")
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }

    }
}