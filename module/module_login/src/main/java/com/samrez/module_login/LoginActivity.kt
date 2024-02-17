package com.samrez.module_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samrez.module_login.ui.theme.AndroidMVIComposeTheme
import id.syarief.android_mvi_compose.module_login.R

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreetingPreview()
        }
    }
}

@Composable
fun Item(answer: Answer, isSelected: Boolean, onAnswerSelected: ((Answer) -> Unit)) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                onAnswerSelected(answer)
            }
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .background(color = if (isSelected) Color.Cyan else Color.White)
            .clip(CircleShape)
            .padding(16.dp)

        ) {
            Image(painter = painterResource(id = answer.image), contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape))
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = answer.name)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = answer.desc ?: "")
            }
        }
    }
}

data class Answer(val image: Int, val name: String, val desc: String?, val clickable: Boolean)

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun GreetingPreview() {
    val data = mutableListOf<Answer>()
    data.add(Answer(R.drawable.ic_launcher_background, "Zacky", "First Data", false))
    data.add(Answer(R.drawable.ic_launcher_background, "Dzacky", "Second Data", true))
    data.add(Answer(R.drawable.ic_launcher_background, "Syarief", "Third Data", false))

    var selectedAnswer: Answer? by rememberSaveable { mutableStateOf(null) }
    AndroidMVIComposeTheme {
        Column {
            data.forEach() {
                Spacer(modifier = Modifier.height(6.dp))
                Item(
                    answer = it,
                    isSelected = (selectedAnswer == it),
                    onAnswerSelected = { answer -> selectedAnswer = answer }
                )
            }
        }
    }
}