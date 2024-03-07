package id.syarief.android_mvi_compose.module_home.ui.feature.detail.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.syarief.android_mvi_compose.module_home.ui.feature.detail.DetailUserContract
import id.syarief.base.base_component.BaseTheme
import id.syarief.base.base_component.CoilImage
import id.syarief.base.base_component.FullAppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailUserScreen(
    userID: String,
    onNavigationRequested: (navigationEffect: DetailUserContract.Effect.Back) -> Unit
) {
    Scaffold(
        modifier = Modifier.background(Color.White),
        topBar = {
            FullAppBar(
                title = "Detail User",
                showBack = true
            ) {
                onNavigationRequested(DetailUserContract.Effect.Back)
            }
        },
        content = {
            Column (
                modifier = Modifier.fillMaxSize().padding(vertical = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CoilImage(
                    url = "https://t3.ftcdn.net/jpg/03/02/88/46/240_F_302884605_actpipOdPOQHDTnFtp4zg4RtlWzhOASp.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .size(70.dp)
                        .clip(CircleShape)
                )
                Text(text = userID, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
        }
    )

}

@Preview
@Composable
fun ShowDetailUserScree() {
    BaseTheme {
        Surface {
            DetailUserScreen(onNavigationRequested = {},
                userID = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=800"
            )
        }
    }
}